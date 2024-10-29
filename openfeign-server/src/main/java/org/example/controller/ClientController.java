package org.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ClientController {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/server/random-uuid", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getRandomUUID() {
        return new ResponseEntity<>(UUID.randomUUID().toString(), HttpStatus.CREATED);
    }

}
