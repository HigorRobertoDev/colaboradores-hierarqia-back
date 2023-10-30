package br.com.hierarquia.colaboradores.bo;

import br.com.hierarquia.colaboradores.dto.request.ColaboradorRequest;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorHierarquiaResponse;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorResponse;
import br.com.hierarquia.colaboradores.dto.response.HierarquiaResponse;
import br.com.hierarquia.colaboradores.metric.PasswordMeter;
import br.com.hierarquia.colaboradores.metric.model.PasswordStrength;
import br.com.hierarquia.colaboradores.model.Colaborador;
import br.com.hierarquia.colaboradores.model.Hierarquia;
import br.com.hierarquia.colaboradores.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ColaboradorBo {

    @Autowired
    private PasswordMeter passwordMeter;

    public Colaborador criarColaborador(ColaboradorRequest colaboradorRequest, Hierarquia hierarquia) {
        PasswordStrength passwordStrength = this.passwordMeter.measure(colaboradorRequest.getSenha());
        String md5 = MD5Utils.getMd5Hash(colaboradorRequest.getSenha());
        return Colaborador.builder()
                .nome(colaboradorRequest.getNome())
                .senha(md5)
                .score(passwordStrength.getScore())
                .complexity(passwordStrength.getComplexity())
                .hierarquia(hierarquia)
                .build();
    }

    public ColaboradorResponse criarColaboradorResponse(Colaborador colaborador) {
        return ColaboradorResponse.builder()
                .id(colaborador.getId())
                .nome(colaborador.getNome())
                .score(colaborador.getScore())
                .complexity(colaborador.getComplexity())
                .hierarquia(HierarquiaResponse.builder()
                        .id(colaborador.getHierarquia().getId())
                        .descricao(colaborador.getHierarquia().getDescricao())
                        .build())
                .build();
    }

    public ColaboradorHierarquiaResponse criarColaboradorHierarquiaResponse(List<Colaborador> colaboradores) {
        List<ColaboradorResponse> colaboradorGerente = this.filtrarColaboradorPorHierarquia(colaboradores, 1);
        List<ColaboradorResponse> colaboradorCoordenador = this.filtrarColaboradorPorHierarquia(colaboradores, 2);
        List<ColaboradorResponse> colaboradorAuxiliar = this.filtrarColaboradorPorHierarquia(colaboradores, 3);
        return ColaboradorHierarquiaResponse.builder()
                .colaboradorGerente(colaboradorGerente)
                .colaboradorCoordenador(colaboradorCoordenador)
                .colaboradorAuxiliar(colaboradorAuxiliar)
                .build();
    }

    public List<ColaboradorResponse> filtrarColaboradorPorHierarquia(List<Colaborador> colaboradores, Integer hierarquia) {
        return Optional.ofNullable(colaboradores)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(colaborador -> colaborador.getHierarquia().getId() == hierarquia)
                .map(colaborador -> this.criarColaboradorResponse(colaborador))
                .collect(Collectors.toList());
    }

}
