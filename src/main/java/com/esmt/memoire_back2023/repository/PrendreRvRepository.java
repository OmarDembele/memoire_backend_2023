package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.PrendreRv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PrendreRvRepository extends JpaRepository<PrendreRv, Long> {
}
