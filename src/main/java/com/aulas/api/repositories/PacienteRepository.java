package com.aulas.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.api.entities.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
