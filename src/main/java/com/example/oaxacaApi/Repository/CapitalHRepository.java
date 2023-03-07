package com.example.oaxacaApi.Repository;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.example.oaxacaApi.Entity.CapitalHEntity;

public interface CapitalHRepository extends JpaRepository<CapitalHEntity, Integer> {
    List<CapitalHEntity> findDataByStatus(Boolean status, Sort sort);
    List<CapitalHEntity> findByFechaInicioBetween(LocalDate fechaDesde, LocalDate fechaHasta);
    List<CapitalHEntity> findByFechaFinBetween(LocalDate fechaDesde, LocalDate fechaHasta);
    List<CapitalHEntity> findByFechaPagoBetween(LocalDate fechaDesde, LocalDate fechaHasta);
    /* List<CapitalHEntity> findByFechaPago(LocalDate fechaPago);
    List<CapitalHEntity> findByFechaInicio(LocalDate fechaInicio);
    List<CapitalHEntity> findByFechaFin(LocalDate fechaFin); */
    // List<CapitalHEntity> findByFechaInicio(LocalDate fechaDesde, LocalDate fechaHasta);
    // List<CapitalHEntity> findByFechaInicioAndFechaFin(LocalDate fechaInicio, LocalDate fechaFin);
}
