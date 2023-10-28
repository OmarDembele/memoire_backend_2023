package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
