package com.example.oaxacaApi.Controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import javax.print.DocFlavor.STRING;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.oaxacaApi.Entity.ArchivoEntity;
import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.ArchivoRepository;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RestController
@RequestMapping("api/Archivo")
public class ArchivoController {
    @Autowired
    ArchivoRepository archivoRepository;

    public String rutaCarpeta = "\\Users\\Propietario\\Pictures\\";

    @PostMapping
    public ResponseEntity<ArchivoEntity> postData(@RequestBody ArchivoEntity data){
        try{
            ArchivoEntity archivoEntity = archivoRepository.save(data);
            return new ResponseEntity<>(archivoEntity, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }     
    }

    /* @PutMapping("/{idArchivo}")
    public ResponseEntity<ArchivoEntity> updateArchivo(@PathVariable("idArchivo") Integer idArchivo){
        Optional <ArchivoEntity> archivoData = archivoRepository.findById(idArchivo);
        if(archivoData.isPresent()){
            ArchivoEntity aEntity = archivoData.get();
            aEntity.setFile(rutaCarpeta);
            return new ResponseEntity<>(archivoRepository.save(aEntity), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } */
    
    @PutMapping("/{idArchivo}")
    public String actulizarArchivo(@PathVariable("idArchivo") Integer idArchivo, @RequestParam("file") MultipartFile multipartFile){
        Optional <ArchivoEntity> archivoData = archivoRepository.findById(idArchivo);
        
        if(!multipartFile.isEmpty() && archivoData.isPresent()){
            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(rutaCarpeta + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                ArchivoEntity aEntity = archivoData.get();
                aEntity.setFile(rutaCarpeta + multipartFile.getOriginalFilename());
                archivoRepository.save(aEntity);
                return "Se guardo";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            return "error";
        }
        return null;
    }
    
    /* @PostMapping
    public String subirArchivo(@RequestParam("file") MultipartFile multipartFile) {

        if (!multipartFile.isEmpty()) {
            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(rutaCarpeta + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                archivoRepository.save(ArchivoEntity.builder()
                        .file(rutaCarpeta + multipartFile.getOriginalFilename()).build());
                return "Se guardo";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    } */

    /* @PostMapping
    public String subirArchivo(@ModelAttribute ArchivoEntity archivoEntity, Model model, @RequestParam("file") MultipartFile multipartFile) {

        if (!multipartFile.isEmpty()) {
            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(rutaCarpeta + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                archivoEntity.setFile(rutaCarpeta + multipartFile.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        archivoRepository.save(archivoEntity);
        return "Se guardo";
    } */
    
    /* @PostMapping
    public String subirArchivo(@ModelAttribute @RequestParam("file") MultipartFile multipartFile) {

        if (!multipartFile.isEmpty()) {
            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(rutaCarpeta + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
                archivoRepository.save(ArchivoEntity.builder()
                        .file(rutaCarpeta + multipartFile.getOriginalFilename()).build());
                return "Se guardo";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    } */
}
