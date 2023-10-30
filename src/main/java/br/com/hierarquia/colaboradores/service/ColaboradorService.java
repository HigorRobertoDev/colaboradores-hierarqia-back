package br.com.hierarquia.colaboradores.service;

import br.com.hierarquia.colaboradores.model.Colaborador;
import br.com.hierarquia.colaboradores.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Colaborador salvarColaborador(Colaborador colaborador) {
        return this.colaboradorRepository.save(colaborador);
    }

    public List<Colaborador> buscarColaboradores() {
        return this.colaboradorRepository.findAll();
    }

}
