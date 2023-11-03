package com.esmt.memoire_back2023.repository;

import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface PersonnelsRepository extends JpaRepository<Personnels, Long> {

    Optional<Personnels> findOneByLoginAndPassword(String login, String password);

    Personnels findByLogin(String login);

    @Query("SELECT p FROM Personnels p WHERE p.role = ?1")
    List<Personnels> findByRole(UserRole role);

}

