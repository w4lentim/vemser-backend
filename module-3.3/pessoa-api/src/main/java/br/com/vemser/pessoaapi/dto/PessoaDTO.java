package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends PessoaCreateDTO {

    @Schema(description = "Identificador (ID) da pessoa.")
    private Integer idPessoa;

    @Schema(description = "Endereços que a pessoa possui")
    private List<EnderecoDTO> enderecoDTO;

    @Schema(description = "Contatos que a pessoa possui")
    private List<ContatoDTO> contatoDTO;

    @Schema(description = "Pet que a pessoa possui")
    private PetDTO petDTO;
}
