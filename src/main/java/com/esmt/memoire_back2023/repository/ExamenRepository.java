package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.ExamenMedical;
import com.esmt.memoire_back2023.entity.NextRv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ExamenRepository extends JpaRepository<ExamenMedical, Long> {

    @Query("SELECT p FROM ExamenMedical p WHERE p.personnel = ?1")
    List<ExamenMedical> findByPersonnel(Long id);
}
