package org.example.controller;

import org.example.client.OpenFeignServerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;


@RestController
public class ApiController {

    private final OpenFeignServerApi openFeignServerApi;
    private Integer counter = 0;

    @Autowired
    public ApiController(OpenFeignServerApi openFeignServerApi) {
        this.openFeignServerApi = openFeignServerApi;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/v1/client/random-uuid", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getRandomUUID() {
        return new ResponseEntity<>(this.openFeignServerApi.getRandomUUID(), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/v1/client/random-uuid/async", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> getRandomUUIDAsync() {
        CompletableFuture.runAsync(() -> {
            String randomUUId = this.openFeignServerApi.getRandomUUID();
            System.out.println((counter +=1) + " : randomUUID: " + randomUUId);
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
