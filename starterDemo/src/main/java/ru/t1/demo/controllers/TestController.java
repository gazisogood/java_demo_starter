package ru.t1.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Hello, this is a test response!");
    }
}
