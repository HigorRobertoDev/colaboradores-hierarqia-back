package br.com.hierarquia.colaboradores.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ColaboradorResponse {

    private Integer id;
    private String nome;
    private Integer score;
    private String complexity;
    private HierarquiaResponse hierarquia;

}
