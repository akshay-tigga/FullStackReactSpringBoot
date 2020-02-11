package com.akki.ispdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ApiController {

    @Autowired
    IspRepository ispRepository;

    @GetMapping(path = "/")
    public String rootFunc() {
        return "Hello World!!";
    }

    @GetMapping(path = "/api/isps")
    public List<IspEntity> getAllIsps() {
        return ispRepository.findAll();
    }

    @GetMapping(path = "/api/isps/{id}")
    public IspEntity getIsp(@PathVariable Long id) {
        return ispRepository.findById(id).get();
    }

    @GetMapping(path = "/api/isps/{id}/download")
    public ResponseEntity<InputStreamResource> downloadIspDetails(@PathVariable Long id) {
        IspEntity ispEntity = ispRepository.findById(id).get();
        ByteArrayInputStream bis = PdfGenerator.generatePdf(ispEntity);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline;");
        return ResponseEntity
                .ok()
                .header(httpHeaders.toString())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
