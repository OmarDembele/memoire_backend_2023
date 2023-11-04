package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long> {
    @Query("SELECT c FROM Hospitalisation c WHERE c.dossierMedical_id = :dossierMedicalId")
    List<Hospitalisation> findByDossierMedicalId(@Param("dossierMedicalId") Long dossierMedicalId);
}
