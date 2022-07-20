package br.com.vemser.pessoaapi.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class PetDTO extends PetCreateDTO {

    @Schema(description = "Identificador (ID) do pet")
    private Integer idPet;
}
