package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.ExamenMedical;
import com.esmt.memoire_back2023.entity.Prescription;
import com.esmt.memoire_back2023.entity.Soins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Query("SELECT p FROM Prescription p WHERE p.personnel = ?1")
    List<Prescription> findByPersonnel(Long id);
}
