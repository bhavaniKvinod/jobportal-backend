package com.htc.jobportal.service.impl;

import com.htc.jobportal.model.Token;
import com.htc.jobportal.repository.TokenRepository;
import com.htc.jobportal.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {
    
    @Autowired
    private TokenRepository tokenRepository;
    
    @Override
    public Token createToken(Token token) {
        return tokenRepository.save(token);
    }
    
    @Override
    public Optional<Token> getTokenById(Long id) {
        return tokenRepository.findById(id);
    }
    
    @Override
    public Optional<Token> getTokenByJwtToken(String jwtToken) {
        return tokenRepository.findByJwtToken(jwtToken);
    }
    
    @Override
    public List<Token> getTokensByUserId(Long userId) {
        return tokenRepository.findByUserId(userId);
    }
    
    @Override
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }
    
    @Override
    public Token updateToken(Long id, Token token) {
        Optional<Token> existingToken = tokenRepository.findById(id);
        if (existingToken.isPresent()) {
            Token tokenToUpdate = existingToken.get();
            tokenToUpdate.setJwtToken(token.getJwtToken());
            tokenToUpdate.setIsExpired(token.getIsExpired());
            tokenToUpdate.setIsRevoked(token.getIsRevoked());
            return tokenRepository.save(tokenToUpdate);
        }
        return null;
    }
    
    @Override
    public void deleteToken(Long id) {
        tokenRepository.deleteById(id);
    }
}
