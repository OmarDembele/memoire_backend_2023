package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.NextRv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface NextRvRepository extends JpaRepository<NextRv, Long> {
}
