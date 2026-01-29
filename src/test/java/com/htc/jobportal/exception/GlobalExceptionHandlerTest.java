package com.htc.jobportal.exception;

import com.htc.jobportal.dto.ErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GlobalExceptionHandlerTest {
    
    private GlobalExceptionHandler exceptionHandler;
    private WebRequest webRequest;
    
    @BeforeEach
    void setUp() {
        exceptionHandler = new GlobalExceptionHandler();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/v1/test");
        webRequest = new ServletWebRequest(request);
    }
    
    @Test
    void testHandleResourceNotFoundException() {
        // Given
        ResourceNotFoundException exception = new ResourceNotFoundException("User", "id", 1L);
        
        // When
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleResourceNotFoundException(exception, webRequest);
        
        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(404, response.getBody().getStatus());
        assertEquals("Not Found", response.getBody().getError());
        assertTrue(response.getBody().getMessage().contains("User not found"));
    }
    
    @Test
    void testHandleBadRequestException() {
        // Given
        BadRequestException exception = new BadRequestException("Invalid input provided");
        
        // When
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleBadRequestException(exception, webRequest);
        
        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(400, response.getBody().getStatus());
        assertEquals("Bad Request", response.getBody().getError());
        assertEquals("Invalid input provided", response.getBody().getMessage());
    }
    
    @Test
    void testHandleUnauthorizedException() {
        // Given
        UnauthorizedException exception = new UnauthorizedException("Access denied");
        
        // When
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleUnauthorizedException(exception, webRequest);
        
        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(401, response.getBody().getStatus());
        assertEquals("Unauthorized", response.getBody().getError());
        assertEquals("Access denied", response.getBody().getMessage());
    }
    
    @Test
    void testHandleMethodArgumentNotValidException() {
        // Given
        BindingResult bindingResult = mock(BindingResult.class);
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);
        
        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(new FieldError("user", "email", "must not be null"));
        fieldErrors.add(new FieldError("user", "password", "must not be blank"));
        
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);
        
        // When
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleMethodArgumentNotValidException(exception, webRequest);
        
        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(400, response.getBody().getStatus());
        assertEquals("Validation Failed", response.getBody().getError());
        assertEquals("Input validation failed", response.getBody().getMessage());
        assertNotNull(response.getBody().getDetails());
        assertEquals(2, response.getBody().getDetails().size());
    }
    
    @Test
    void testHandleGlobalException() {
        // Given
        Exception exception = new Exception("Unexpected error occurred");
        
        // When
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleGlobalException(exception, webRequest);
        
        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(500, response.getBody().getStatus());
        assertEquals("Internal Server Error", response.getBody().getError());
        assertEquals("Unexpected error occurred", response.getBody().getMessage());
    }
}
