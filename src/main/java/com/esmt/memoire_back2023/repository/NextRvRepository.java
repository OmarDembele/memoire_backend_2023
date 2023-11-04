package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.NextRv;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface NextRvRepository extends JpaRepository<NextRv, Long> {

    @Query("SELECT p FROM NextRv p WHERE p.personnel = ?1")
    List<NextRv> findByPersonnel(Long id);
}
