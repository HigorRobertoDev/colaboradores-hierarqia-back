package br.com.hierarquia.colaboradores.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ColaboradorHierarquiaResponse {
    private List<ColaboradorResponse> colaboradorGerente;
    private List<ColaboradorResponse> colaboradorCoordenador;
    private List<ColaboradorResponse> colaboradorAuxiliar;
}
