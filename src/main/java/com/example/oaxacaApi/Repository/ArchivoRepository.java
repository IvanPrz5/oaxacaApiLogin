package com.example.oaxacaApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oaxacaApi.Entity.ArchivoEntity;

public interface ArchivoRepository extends JpaRepository<ArchivoEntity, Integer>  {
    
}
