package com.example.oaxacaApi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oaxacaApi.Entity.UsuariosEntity;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {
    Optional<UsuariosEntity> findOneByEmail(String email);
}
