package com.aulas.api.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aulas.api.repositories.PacienteRepository;
import com.aulas.api.entities.Paciente;

@Service

public class PacienteService {

    @Autowired
    private PacienteRepository repository;


    public List<com.aulas.api.entities.Paciente> buscarTodos() {
        return repository.findAll();
    }

    public com.aulas.api.entities.Paciente buscaPaciente(String cpf) {
        Optional<com.aulas.api.entities.Paciente> optionalPaciente = repository.findById(cpf);
        return optionalPaciente.orElseThrow(() -> new RuntimeException());
    }

    public String criarPaciente(Paciente paciente) {
        repository.save(paciente);
        return "Paciente cadastrado com sucesso!";

    }

    public String editarPaciente(String cpf, Paciente paciente) {
        Paciente response = repository.findById(cpf).get();
        repository.save(response);
        return "Paciente editado com sucesso";
    }

    public void excluirPaciente(String cpf) {
        Paciente response = repository.findById(cpf).get();
        repository.delete(response);
    }
}
