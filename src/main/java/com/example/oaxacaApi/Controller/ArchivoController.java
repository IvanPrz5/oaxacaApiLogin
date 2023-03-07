package com.example.oaxacaApi.Controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.oaxacaApi.Entity.ArchivoEntity;
import com.example.oaxacaApi.Repository.ArchivoRepository;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/Archivo")
public class ArchivoController {
    @Autowired
    ArchivoRepository archivoRepository;

    public String rutaCarpeta = "\\Users\\Propietario\\Pictures\\";

    @PostMapping
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
    }
}
