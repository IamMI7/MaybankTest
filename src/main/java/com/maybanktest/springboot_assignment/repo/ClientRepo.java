package com.maybanktest.springboot_assignment.repo;

import com.maybanktest.springboot_assignment.entities.ClientEntity;
import com.maybanktest.springboot_assignment.models.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<ClientEntity, Long> {
    @Query("SELECT new com.maybanktest.springboot_assignment.models.ClientDTO(" +
            "c.username," +
            "c.full_name," +
            "c.addreess," +
            "c.email," +
            "c.contact_number" +
            ") FROM Client c")
    Page<ClientDTO> findAllAsDto(Pageable pageable);

    Optional<ClientEntity> findByUsername(String username);
}
