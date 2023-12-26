package com.aulas.api.entities;

import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Paciente {

    private Integer id;

    private String nome;
    @Id
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    @JsonBackReference
    private Medico medico;

    public Paciente () {}

    public Paciente(Integer id, String nome, String cpf, Medico medico) {
        this.id = id;
        this.cpf = cpf;
        this.medico = medico;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
