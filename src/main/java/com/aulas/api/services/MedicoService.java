package com.aulas.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aulas.api.repositories.MedicoRepository;
import com.aulas.api.entities.Medico;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;


    public List<com.aulas.api.entities.Medico> buscarTodos() {
        return repository.findAll();
    }

    public com.aulas.api.entities.Medico buscarMedico(Integer id) {
        Optional<com.aulas.api.entities.Medico> optionalMedico = repository.findById(id);
        return optionalMedico.orElseThrow(() -> new RuntimeException());
    }

    public String criarMedico(Medico medico) {
        repository.save(medico);
        return "Médico cadastrado com sucesso!";

    }

    public String editarMedico(Integer id, Medico medico) {
        Medico response = repository.findById(id).get();
        repository.save(response);
        return "Médico editado com sucesso";
    }

    public void excluirMedico(Integer id) {
        Medico response = repository.findById(id).get();
        repository.delete(response);
    }
}

