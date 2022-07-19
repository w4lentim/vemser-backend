package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProfessorService {

    private ProfessorRepository professorRepository;
}
