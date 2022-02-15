package com.challenge.bycoders.controller;

import com.challenge.bycoders.factory.impl.TransacaoFactoryImpl;
import com.challenge.bycoders.service.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequestMapping("cnab-api")
public class FileUploadController {

    @Autowired
    private ITransacaoService transacaoService;

    @PostMapping("/upload")
    public ResponseEntity<Void> upload(@RequestParam MultipartFile file) throws Exception {
        if (isExtensaoValida(file)) {
            throw new HttpMediaTypeNotSupportedException("Extensão inválida!");
        }
        transacaoService.salvarTransacoes(new TransacaoFactoryImpl(), file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private boolean isExtensaoValida(MultipartFile arquivo) {
        if (Objects.nonNull(arquivo) && Objects.nonNull(arquivo.getContentType())) {
            return !arquivo.getContentType().equals(MediaType.TEXT_PLAIN_VALUE);
        }
        return false;
    }
}
