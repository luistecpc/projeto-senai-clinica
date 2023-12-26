package com.aulas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.aulas.api.entities.Medico;
import com.aulas.api.services.MedicoService;

@RestController
@RequestMapping("/medico")

public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping
    public ResponseEntity<List<Medico>> buscaTodos() {
        List<Medico> listaMedico = service.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listaMedico);
    }

    @GetMapping(value = "/{id}")
    public Medico buscarMedico(@PathVariable Integer id) {
        Medico medico = service.buscarMedico(id);
        return medico;
    }
    
    @PostMapping
    public ResponseEntity<String> criarPaciente(@RequestBody Medico medico) {
        service.criarMedico(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body("Médico cadastrado.");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> editarPaciente(@PathVariable Integer id, @RequestBody Medico medico) {
    String response = service.editarMedico(id, medico);
    return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirMedico(@PathVariable Integer id) {
    service.excluirMedico(id);
    return ResponseEntity.ok("Médico excluído com sucesso.");
    }

    

}
