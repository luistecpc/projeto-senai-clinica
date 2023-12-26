package com.aulas.api.entities;

import java.util.List;

import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class Medico {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String medico;
    private String crm;

    @OneToMany(mappedBy = "medico")
    @JsonManagedReference
    private List<Paciente> paciente;

    public Medico () {}

    public Medico(Integer id, String medico, String crm, List<Paciente> paciente) {
        this.id = id;
        this.medico = medico;
        this.crm = crm;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }


}
