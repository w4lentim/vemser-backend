package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.client.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.client.dto.PetDTO;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;

    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(this::petEntityToPetDTO).toList();
    }

    public PetDTO create(PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        log.info("Cadastrando o seu pet...");

        PetEntity petEntity = petDTOToPetEntity(petCreateDTO);
        petEntity.setPessoaEntity(pessoaService.findByIdPessoa(petEntity.getIdPessoa()));
        PetDTO petDTO = petEntityToPetDTO(petRepository.save(petEntity));

        log.info("O " + petDTO.getNome() + " foi cadastrado com sucesso!");
        return petDTO;
    }

    public PetDTO update(Integer idPet, PetCreateDTO petAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando dados do pet...");

        PetEntity petEntity = petDTOToPetEntity(petAtualizar);
        petEntity.setIdPet(idPet);
        petEntity.setPessoaEntity(pessoaService.findByIdPessoa(petAtualizar.getIdPessoa()));
        PetDTO petDTO = petEntityToPetDTO(petRepository.save(petEntity));

        log.info("Parabéns, os dados do " + petDTO.getNome() + " foram atualizados com sucesso!");
        return petDTO;
    }

    public void delete(Integer idPet) throws RegraDeNegocioException {
        PetEntity petEntity = findByIdPet(idPet);
        log.info("Removendo o pet...");
        petRepository.delete(petEntity);
        log.info("O pet foi removido com sucesso!");
    }

    public PetEntity findByIdPet(Integer idPet) throws RegraDeNegocioException {
        return petRepository.findById(idPet).orElseThrow(() -> new RegraDeNegocioException("Infelizmente não foi encontrado nenhum pet referente ao id informado."));
    }

    public PetDTO petEntityToPetDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }

    public PetEntity petDTOToPetEntity(PetCreateDTO petCreateDTO) {
        return objectMapper.convertValue(petCreateDTO, PetEntity.class);
    }
}
