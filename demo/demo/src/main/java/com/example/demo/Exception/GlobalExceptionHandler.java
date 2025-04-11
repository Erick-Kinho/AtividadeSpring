package com.example.demo.Exception;

import org.springframework.http.HttpStatus;  // Importa o status HTTP para resposta
import org.springframework.http.ResponseEntity;  // Importa a classe para construir a resposta HTTP
import org.springframework.web.HttpRequestMethodNotSupportedException;  // Exceção gerada quando um método HTTP não é suportado
import org.springframework.web.bind.MethodArgumentNotValidException;  // Exceção gerada quando os argumentos de um método não são válidos
import org.springframework.web.bind.annotation.ExceptionHandler;  // Anotação para capturar exceções específicas
import org.springframework.web.bind.annotation.RestControllerAdvice;  // Anotação que define um controlador global de exceções

import java.util.Map;  // Importa a classe Map para estruturar a resposta da exceção

// O @RestControllerAdvice permite tratar exceções de forma global em toda a aplicação.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Método para capturar exceções do tipo RuntimeException
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handlerRuntimeException(RuntimeException erro) {
        // Retorna uma resposta com status BAD_REQUEST (400) e a mensagem de erro
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)  // Define o status da resposta como 400 (BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage()));  // A resposta contém uma mensagem de erro
    }

    // Método para capturar exceções de validação de argumento de método
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException erro) {
        // Retorna uma resposta com status BAD_REQUEST (400) e a mensagem de erro do primeiro campo inválido
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)  // Define o status da resposta como 400 (BAD_REQUEST)
                .body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));  // Exibe a mensagem do primeiro erro de campo
    }

    // Método para capturar exceções quando um método HTTP não é suportado
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro) {
        // Retorna uma resposta com status NOT_FOUND (404) e uma mensagem personalizada
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)  // Define o status da resposta como 404 (NOT_FOUND)
                .body(Map.of("mensagem","Recurso não encontrado."));  // Mensagem de erro personalizada
    }
}
