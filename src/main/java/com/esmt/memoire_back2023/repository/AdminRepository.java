package com.esmt.memoire_back2023.repository;


import com.esmt.memoire_back2023.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findOneByLoginAndPassword(String login, String password);

    Admin findByLogin(String login);
}

