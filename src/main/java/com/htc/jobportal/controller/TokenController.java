package com.htc.jobportal.controller;

import com.htc.jobportal.model.Token;
import com.htc.jobportal.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tokens")
public class TokenController {
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity<Token> createToken(@RequestBody Token token) {
        Token createdToken = tokenService.createToken(token);
        return new ResponseEntity<>(createdToken, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Token> getTokenById(@PathVariable Long id) {
        Optional<Token> token = tokenService.getTokenById(id);
        return token.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/jwt/{jwtToken}")
    public ResponseEntity<Token> getTokenByJwtToken(@PathVariable String jwtToken) {
        Optional<Token> token = tokenService.getTokenByJwtToken(jwtToken);
        return token.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Token>> getTokensByUserId(@PathVariable Long userId) {
        List<Token> tokens = tokenService.getTokensByUserId(userId);
        return new ResponseEntity<>(tokens, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Token>> getAllTokens() {
        List<Token> tokens = tokenService.getAllTokens();
        return new ResponseEntity<>(tokens, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Token> updateToken(@PathVariable Long id, @RequestBody Token token) {
        Token updatedToken = tokenService.updateToken(id, token);
        if (updatedToken != null) {
            return new ResponseEntity<>(updatedToken, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToken(@PathVariable Long id) {
        tokenService.deleteToken(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
