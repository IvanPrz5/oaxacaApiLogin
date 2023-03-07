package com.example.oaxacaApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.oaxacaApi.Entity.FinalizadoEntity;
import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.FinalizadoRepository;
import com.example.oaxacaApi.Repository.TimbradoRepository;

@Service
public class FinalizadoService {
    @Autowired
    FinalizadoRepository finalizadoRepository;

    @Autowired
    TimbradoRepository timbradoRepository;

    public List<FinalizadoEntity> getIdTimbrado(Integer idTimbrado){
        Optional <TimbradoEntity> timbrado = timbradoRepository.findById(idTimbrado);
        TimbradoEntity timbradoId = timbrado.get();
        return finalizadoRepository.findByTimbradoEntity(timbradoId);
    }

    public List <FinalizadoEntity> getByIdTimbradoAndStatus(Integer idTimbrado, Boolean status, Sort sort){
        Optional<TimbradoEntity> timbrado = timbradoRepository.findById(idTimbrado);
        TimbradoEntity timbradoId = timbrado.get();
        List<FinalizadoEntity> finalizado = finalizadoRepository.findByStatus(status);
        Boolean statusBoolean = finalizado.add(null);
        sort = Sort.by("id");
        return finalizadoRepository.findDataByTimbradoEntityAndStatus(timbradoId, statusBoolean, sort);
    }
}