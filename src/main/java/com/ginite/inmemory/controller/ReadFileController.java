package com.ginite.inmemory.controller;

import com.ginite.inmemory.domain.Person;
import com.ginite.inmemory.model.jolmodel.DatasetWrapper;
import com.ginite.inmemory.service.ConversionService;
import com.ginite.inmemory.service.PersonTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadFileController {

    @Autowired
    ConversionService conversionService;

    @Autowired
    PersonTestServiceImpl personTestService;

    @GetMapping(value = "/readFromFile")
    public ResponseEntity<String> readFromFile() {
//        conversionService.getDatasetWrapper();
        personTestService.insertDatasetWrapper();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/readCache")
    public ResponseEntity<DatasetWrapper> readFromCache() {
        DatasetWrapper response = personTestService.readFromCache();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/playPerson")
    public ResponseEntity<String> playWithPerson() {
        personTestService.playWithPerson();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
