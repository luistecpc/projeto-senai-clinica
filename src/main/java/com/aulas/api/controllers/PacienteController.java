package com.aulas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.aulas.api.entities.Paciente;
import com.aulas.api.services.PacienteService;

@RestController
@RequestMapping("/paciente")

public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> buscaTodos() {
        List<Paciente> listaPaciente = service.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listaPaciente);
    }

    @GetMapping(value = "/{cpf}")
    public Paciente buscarPaciente(@PathVariable String cpf) {
        Paciente paciente = service.buscaPaciente(cpf);
        return paciente;
    }
    
    @PostMapping
    public ResponseEntity<String> criarPaciente(@RequestBody Paciente paciente) {
        service.criarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paciente cadastrado.");
    }

    @PutMapping(value = "/{cpf}")
    public ResponseEntity<String> editarPaciente(@PathVariable String cpf, @RequestBody Paciente paciente) {
    String response = service.editarPaciente(cpf, paciente);
    return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<String> excluirEscola(@PathVariable String cpf) {
    service.excluirPaciente(cpf);
    return ResponseEntity.ok("Paciente excluído com sucesso.");
    }

    

}

