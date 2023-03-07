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

import com.example.oaxacaApi.Entity.CatalogoSNFCEntity;
import com.example.oaxacaApi.Repository.CatalogoSNFCRepository;

@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/SNFC")
public class CatalogoSNFCController {
    @Autowired
    private CatalogoSNFCRepository catalogoSNFCRepository;

    @GetMapping
    public List<CatalogoSNFCEntity> getData(){
        return (List <CatalogoSNFCEntity>) catalogoSNFCRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<CatalogoSNFCEntity> postData(@RequestBody CatalogoSNFCEntity data){
        try{
            CatalogoSNFCEntity catalogoSNFCEntity = catalogoSNFCRepository.save(data);
            return new ResponseEntity<>(catalogoSNFCEntity, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
