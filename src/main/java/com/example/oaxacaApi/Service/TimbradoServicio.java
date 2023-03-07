package com.example.oaxacaApi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.CapitalHRepository;
import com.example.oaxacaApi.Repository.TimbradoRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class TimbradoServicio {
    @Autowired
    TimbradoRepository timbradoRepository;

    @Autowired
    CapitalHRepository capitalHRepository;

    public Optional<TimbradoEntity> getId(Integer id){
        return timbradoRepository.findById(id);
    }

    /* public List<TimbradoEntity> getIdCapitalHumano(Integer idCapitalHumano){
        Optional<CapitalHEntity> capitalHumano = capitalHRepository.findById(idCapitalHumano);
        CapitalHEntity capitalHumanoID = capitalHumano.get();
        return timbradoRepository.findByCapitalHEntity(capitalHumanoID);
    }

    public List<TimbradoEntity> getDataByStatus(Boolean status){
        List<TimbradoEntity> timbrado = timbradoRepository.findDataByStatus(status);
        return timbrado;
    } */

    public List<TimbradoEntity> getByIdCapitalHumanoAndStatus(Integer idCapitalHumano, Boolean status, Sort sort){
        Optional<CapitalHEntity> capitalHumano = capitalHRepository.findById(idCapitalHumano);
        CapitalHEntity capitalHumanoID = capitalHumano.get();
        List<TimbradoEntity> timbrado = timbradoRepository.findDataByStatus(status);      
        Boolean statusBoolean = timbrado.add(null);
        sort = Sort.by("id");
        return timbradoRepository.findDataByCapitalHEntityAndStatus(capitalHumanoID, statusBoolean, sort);
    }
}
