package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
