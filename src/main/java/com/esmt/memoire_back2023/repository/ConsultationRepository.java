package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    @Query("SELECT c FROM Consultation c WHERE c.dossierMedical_id = :dossierMedicalId")
    List<Consultation> findByDossierMedicalId(@Param("dossierMedicalId") Long dossierMedicalId);
}
