package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.Soins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface SoinsRepository extends JpaRepository<Soins, Long> {
    @Query("SELECT s FROM Soins s WHERE s.personnel_id = :personnelId")
    List<Soins> findSoinsByPersonnelId(@Param("personnelId") Long personnelId);
}
