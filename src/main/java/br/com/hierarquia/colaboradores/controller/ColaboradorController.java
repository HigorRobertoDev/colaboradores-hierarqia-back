package br.com.hierarquia.colaboradores.controller;

import br.com.hierarquia.colaboradores.dto.request.ColaboradorRequest;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorHierarquiaResponse;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorResponse;
import br.com.hierarquia.colaboradores.facade.ColaboradorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorFacade colaboradorFacade;

    @CrossOrigin(value = "*")
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<ColaboradorResponse> salvarColaborador(@RequestBody ColaboradorRequest request) {
        ColaboradorResponse response = this.colaboradorFacade.salvarColaborador(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<List<ColaboradorResponse>> buscarColaboradores() {
        List<ColaboradorResponse> response = this.colaboradorFacade.buscarColaboradores();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(
            value = "/hierarquia",
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<ColaboradorHierarquiaResponse> buscarColaboradoresHierarquia() {
        ColaboradorHierarquiaResponse response = this.colaboradorFacade.buscarColaboradoresHierarquia();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
