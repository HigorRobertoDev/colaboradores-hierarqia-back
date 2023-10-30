package br.com.hierarquia.colaboradores.facade.imp;

import br.com.hierarquia.colaboradores.bo.ColaboradorBo;
import br.com.hierarquia.colaboradores.dto.request.ColaboradorRequest;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorHierarquiaResponse;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorResponse;
import br.com.hierarquia.colaboradores.facade.ColaboradorFacade;
import br.com.hierarquia.colaboradores.model.Colaborador;
import br.com.hierarquia.colaboradores.model.Hierarquia;
import br.com.hierarquia.colaboradores.service.ColaboradorService;
import br.com.hierarquia.colaboradores.service.HierarquiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ColaboradorFacadeImp implements ColaboradorFacade {

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    HierarquiaService hierarquiaService;

    @Autowired
    ColaboradorBo colaboradorBo;

    @Override
    public ColaboradorResponse salvarColaborador(ColaboradorRequest colaboradorRequest) {
        Hierarquia hierarquia = this.hierarquiaService.buscarHierarquiaPorId(colaboradorRequest.getHierarquiaId());
        Colaborador colaboradorParaSalvar = this.colaboradorBo.criarColaborador(colaboradorRequest, hierarquia);
        Colaborador colaboradorSalvo = this.colaboradorService.salvarColaborador(colaboradorParaSalvar);
        return this.colaboradorBo.criarColaboradorResponse(colaboradorSalvo);
    }

    @Override
    public List<ColaboradorResponse> buscarColaboradores() {
        List<Colaborador> colaboradores = this.colaboradorService.buscarColaboradores();
        return Optional.ofNullable(colaboradores)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(colaborador -> this.colaboradorBo.criarColaboradorResponse(colaborador))
                .collect(Collectors.toList());
    }

    @Override
    public ColaboradorHierarquiaResponse buscarColaboradoresHierarquia() {
        List<Colaborador> colaboradores = this.colaboradorService.buscarColaboradores();
        return this.colaboradorBo.criarColaboradorHierarquiaResponse(colaboradores);
    }
}
