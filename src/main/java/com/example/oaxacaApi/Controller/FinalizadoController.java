package com.example.oaxacaApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import com.example.oaxacaApi.Entity.FinalizadoEntity;
import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.FinalizadoRepository;
import com.example.oaxacaApi.Service.FinalizadoService;
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/Finalizado")
public class FinalizadoController {
    @Autowired
    private FinalizadoRepository finalizadoRepository;
    @Autowired
    private FinalizadoService finalizadoService;

    @GetMapping
    public List <FinalizadoEntity> getData(){
        return (List<FinalizadoEntity>) finalizadoRepository.findAll();
    }

    @GetMapping("/{idFinalizado}")
    public Optional<FinalizadoEntity> getDataById(@PathVariable("idFinalizado") Integer idFinalizado){
        return finalizadoRepository.findById(idFinalizado);
    }

    @GetMapping("/dataTimbrado/{idTimbrado}")
    public List <FinalizadoEntity> getDataTimbrado(@PathVariable("idTimbrado") Integer timbradoEntity){
        return (List<FinalizadoEntity>) finalizadoService.getIdTimbrado(timbradoEntity);
    }

    @GetMapping("/dataFinalizado/{idTimbrado}/{statusFinalizado}")
    public List<FinalizadoEntity> getDataByIdTimbradoAndStatus(@PathVariable("idTimbrado") Integer timbradoEntity, @PathVariable("statusFinalizado") Boolean status, Sort sort) {
        return (List<FinalizadoEntity>) finalizadoService.getByIdTimbradoAndStatus(timbradoEntity, status, sort);
    }

    @PostMapping
    public ResponseEntity<FinalizadoEntity> postData(@RequestBody FinalizadoEntity data){
        try{
            FinalizadoEntity finalizadoEntity = finalizadoRepository.save(data);
            return new ResponseEntity<>(finalizadoEntity, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idFinalizado}")
    public ResponseEntity<FinalizadoEntity> putMapping(@PathVariable("idFinalizado") Integer idFinalizado, @RequestBody FinalizadoEntity finalizadoEntity){
        Optional <FinalizadoEntity> finalizadoData = finalizadoRepository.findById(idFinalizado);
        
        if(finalizadoData.isPresent()){
            FinalizadoEntity fEntity = finalizadoData.get();
            fEntity.setResultado(finalizadoEntity.getResultado());
            fEntity.setExito(finalizadoEntity.getExito());
            fEntity.setFallidos(finalizadoEntity.getFallidos());
            fEntity.setIsrTimbrado(finalizadoEntity.getIsrTimbrado());
            fEntity.setUrlDescarga(finalizadoEntity.getUrlDescarga());
            fEntity.setPdf(finalizadoEntity.getPdf());
            fEntity.setFechaFinalizado(finalizadoEntity.getFechaFinalizado());
            fEntity.setQr(finalizadoEntity.getQr());
            fEntity.setObservaciones(finalizadoEntity.getObservaciones());
            fEntity.setXml(finalizadoEntity.getXml());            
            fEntity.setStatus(finalizadoEntity.getStatus());
            return new ResponseEntity<>(finalizadoRepository.save(fEntity), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/statusFinalizado/{idFinalizado}")
    public ResponseEntity <FinalizadoEntity> updatingStatus(@PathVariable("idFinalizado") Integer idFinalizado, @RequestBody FinalizadoEntity finalizadoEntity){
        Optional <FinalizadoEntity> finalizadoData = finalizadoRepository.findById(idFinalizado);

        if(finalizadoData.isPresent()){
            FinalizadoEntity fEntity = finalizadoData.get();
            fEntity.setStatus(finalizadoEntity.getStatus());
            return new ResponseEntity<>(finalizadoRepository.save((fEntity)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}