package br.com.hierarquia.colaboradores.service;

import br.com.hierarquia.colaboradores.model.Hierarquia;
import br.com.hierarquia.colaboradores.repository.HierarquiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HierarquiaService {

    @Autowired
    private HierarquiaRepository hierarquiaRepository;

    public Hierarquia buscarHierarquiaPorId(Integer id) {
        return this.hierarquiaRepository.findById(id).get();
    }
}
