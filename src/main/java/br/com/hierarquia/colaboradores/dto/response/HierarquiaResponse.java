package br.com.hierarquia.colaboradores.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HierarquiaResponse {

    private Integer id;
    private String descricao;
}
