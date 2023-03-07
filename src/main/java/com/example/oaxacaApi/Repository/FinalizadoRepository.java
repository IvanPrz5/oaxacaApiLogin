package com.example.oaxacaApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import com.example.oaxacaApi.Entity.FinalizadoEntity;
import com.example.oaxacaApi.Entity.TimbradoEntity;
import org.springframework.data.domain.Sort;

public interface FinalizadoRepository extends JpaRepository<FinalizadoEntity, Integer> {
    List<FinalizadoEntity> findByTimbradoEntity(TimbradoEntity idTimbrado);    
    List<FinalizadoEntity> findByStatus(Boolean status);
    List<FinalizadoEntity> findDataByTimbradoEntityAndStatus(TimbradoEntity idTimbrado, Boolean status, Sort sort);
}