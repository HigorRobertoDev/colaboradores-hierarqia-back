package br.com.hierarquia.colaboradores.facade;

import br.com.hierarquia.colaboradores.dto.request.ColaboradorRequest;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorHierarquiaResponse;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorResponse;

import java.util.List;

public interface ColaboradorFacade {

    ColaboradorResponse salvarColaborador(ColaboradorRequest colaboradorRequest);
    List<ColaboradorResponse> buscarColaboradores();
    ColaboradorHierarquiaResponse buscarColaboradoresHierarquia();

}
