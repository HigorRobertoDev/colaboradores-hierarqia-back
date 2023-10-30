package br.com.hierarquia.colaboradores.controller;

import br.com.hierarquia.colaboradores.dto.request.ColaboradorRequest;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorHierarquiaResponse;
import br.com.hierarquia.colaboradores.dto.response.ColaboradorResponse;
import br.com.hierarquia.colaboradores.dto.response.HierarquiaResponse;
import br.com.hierarquia.colaboradores.facade.ColaboradorFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@WebMvcTest(value = ColaboradorController.class)
public class ColaboradorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ColaboradorFacade colaboradorFacade;

    private static final String URL = "/colaboradores";

    @Test
    public void salvarColaboradorTest() throws Exception {
        ColaboradorRequest request = ColaboradorRequest.builder()
                .nome("Higão")
                .senha("1234")
                .hierarquiaId(1)
                .build();
        ColaboradorResponse response = ColaboradorResponse.builder()
                .id(1)
                .nome("Higão")
                .score(71)
                .complexity("Forte")
                .hierarquia(HierarquiaResponse.builder()
                        .id(1)
                        .descricao("GERENTE")
                        .build())
                .build();
        when(this.colaboradorFacade.salvarColaborador(request))
                .thenReturn(response);
        mockMvc
                .perform(MockMvcRequestBuilders.post(URL)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
        verify(this.colaboradorFacade, times(1))
                .salvarColaborador(request);
    }

    @Test
    public void buscarColaboradoresTest() throws Exception {
        List<ColaboradorResponse> response = Arrays.asList(
                ColaboradorResponse.builder()
                        .id(1)
                        .nome("Higão")
                        .score(71)
                        .complexity("Forte")
                        .hierarquia(HierarquiaResponse.builder()
                                .id(1)
                                .descricao("GERENTE")
                                .build())
                        .build()
        );
        when(this.colaboradorFacade.buscarColaboradores())
                .thenReturn(response);
        mockMvc
                .perform(MockMvcRequestBuilders.get(URL))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
        verify(this.colaboradorFacade, times(1))
                .buscarColaboradores();
    }

    @Test
    public void buscarColaboradoresHierarquiaTest() throws Exception {
        ColaboradorHierarquiaResponse response = ColaboradorHierarquiaResponse.builder()
                .colaboradorGerente(Arrays.asList(
                        ColaboradorResponse.builder()
                                .id(1)
                                .nome("Higão")
                                .score(71)
                                .complexity("Forte")
                                .hierarquia(HierarquiaResponse.builder()
                                        .id(1)
                                        .descricao("GERENTE")
                                        .build())
                                .build()
                ))
                .colaboradorCoordenador(new ArrayList<>())
                .colaboradorAuxiliar(new ArrayList<>())
                .build();

        when(this.colaboradorFacade.buscarColaboradoresHierarquia())
                .thenReturn(response);
        mockMvc
                .perform(MockMvcRequestBuilders.get(URL + "/hierarquia"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
        verify(this.colaboradorFacade, times(1))
                .buscarColaboradoresHierarquia();
    }

}
