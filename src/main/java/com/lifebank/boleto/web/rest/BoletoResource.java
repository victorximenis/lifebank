package com.lifebank.boleto.web.rest;

import com.lifebank.boleto.entity.Boleto;
import com.lifebank.boleto.service.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RequestMapping("/boletos")
@RestController
public class BoletoResource {

    @Autowired
    BoletoService boletoService;

    @GetMapping
    public List<Boleto> listarBoletos() {
        return this.boletoService.listarBoletos();
    }

    @GetMapping(value = "/gerar/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> gerarBoleto(@PathVariable Long id) {

        byte[] pdf = this.boletoService.gerarBoleto(id);

        if (pdf != null) {
            ByteArrayInputStream bis = new ByteArrayInputStream(pdf);

            HttpHeaders header = new HttpHeaders();
            header.add("Content-Disposition", "inline; filename=boleto.pdf");

            return ResponseEntity
                    .ok()
                    .headers(header)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(bis));
        } else {
            return ResponseEntity
                    .ok()
                    .headers(new HttpHeaders())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new InputStreamResource(null));
        }
    }

}
