package com.example.oaxacaApi.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Repository.CapitalHRepository;


@Service
public class CapitalHService {
    @Autowired
    CapitalHRepository capitalHRepository;

    public List<CapitalHEntity> getDataByStatus(Boolean status, Sort sort){
        sort = Sort.by("id");
        List<CapitalHEntity> capitalHumano = capitalHRepository.findDataByStatus(status, sort);
        // CapitalHEntity capitalHumanoStatus = capitalHumano.get();
        return capitalHumano;
    }

    public List<CapitalHEntity> getDataByFechaInicio(String fechaDesde, String fechaHasta) throws ParseException {
        LocalDate fechaDesdeLD = LocalDate.parse(fechaDesde);
        LocalDate fechaHastaLD = LocalDate.parse(fechaHasta);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaInicioBetween(fechaDesdeLD, fechaHastaLD);
        return capitalHumano;
    }

    public List<CapitalHEntity> getDataByFechaFin(String fechaDesde, String fechaHasta) throws ParseException {
        LocalDate fechaDesdeLD = LocalDate.parse(fechaDesde);
        LocalDate fechaHastaLD = LocalDate.parse(fechaHasta);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaFinBetween(fechaDesdeLD, fechaHastaLD);
        return capitalHumano;
    }

    public List<CapitalHEntity> getDataByFechaPago(String fechaDesde, String fechaHasta) throws ParseException {
        LocalDate fechaDesdeLD = LocalDate.parse(fechaDesde);
        LocalDate fechaHastaLD = LocalDate.parse(fechaHasta);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaPagoBetween(fechaDesdeLD, fechaHastaLD);
        return capitalHumano;
    }

   /*  public List<CapitalHEntity> getDataByBetweenFechaInicio(String fechaDesde, String fechaHasta) throws ParseException {
        LocalDate fechaDesdeLD = LocalDate.parse(fechaDesde);
        LocalDate fechaHastaLD = LocalDate.parse(fechaHasta);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaInicio(fechaDesdeLD, fechaHastaLD);
        return capitalHumano;
    } */

    /* public List<CapitalHEntity> getDataByFechaInicio(String fechaInicio) throws ParseException {
        LocalDate fechaInicioLD = LocalDate.parse(fechaInicio);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaInicio(fechaInicioLD);
        return capitalHumano;
    }

    public List<CapitalHEntity> getDataByFechaFin(String fechaFin) throws ParseException {
        LocalDate fechaFinLD = LocalDate.parse(fechaFin);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaFin(fechaFinLD);
        return capitalHumano;
    }

    public List<CapitalHEntity> getDataByFechaPago(String fechaPago) throws ParseException {        
        LocalDate fechaPagoLD = LocalDate.parse(fechaPago);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaPago(fechaPagoLD);
        return capitalHumano;
    } */

    /* public List<CapitalHEntity> getDataByFechaInicioAndFechaFin(String fechaInicio, String fechaFin) throws ParseException {
        LocalDate fechaInicioLD = LocalDate.parse(fechaInicio);
        LocalDate fechaFinLD = LocalDate.parse(fechaFin);
        List<CapitalHEntity> capitalHumano = capitalHRepository.findByFechaInicioAndFechaFin(fechaInicioLD, fechaFinLD);
        return capitalHumano;
    } */
}
