package com.htc.jobportal.service;

import com.htc.jobportal.model.Token;
import java.util.List;
import java.util.Optional;

public interface TokenService {
    Token createToken(Token token);
    Optional<Token> getTokenById(Long id);
    Optional<Token> getTokenByJwtToken(String jwtToken);
    List<Token> getTokensByUserId(Long userId);
    List<Token> getAllTokens();
    Token updateToken(Long id, Token token);
    void deleteToken(Long id);
}
