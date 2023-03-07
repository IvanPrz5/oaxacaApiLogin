package com.example.oaxacaApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Entity.CatalogoStatusEntity;
import com.example.oaxacaApi.Repository.CapitalHRepository;
import com.example.oaxacaApi.Repository.CatalogoStatusRepository;

@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/Status")
public class CatalogoStatusController {
    @Autowired
    private CatalogoStatusRepository catalogoStatusRepository;

    @GetMapping
    public List<CatalogoStatusEntity> getData(){
        return (List<CatalogoStatusEntity>) catalogoStatusRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<CatalogoStatusEntity> postData(@RequestBody CatalogoStatusEntity data){
        try{
            CatalogoStatusEntity catalogoStatusEntity = catalogoStatusRepository.save(data);
            return new ResponseEntity<>(catalogoStatusEntity, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
