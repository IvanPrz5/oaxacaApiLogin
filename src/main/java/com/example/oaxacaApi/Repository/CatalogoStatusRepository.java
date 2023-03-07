package com.example.oaxacaApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oaxacaApi.Entity.CatalogoStatusEntity;

public interface CatalogoStatusRepository extends JpaRepository<CatalogoStatusEntity, String> {
    
}
