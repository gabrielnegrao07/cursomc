package br.com.gabriel.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.gabriel.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	/**
	 * Essas informações são padrão do ControllerAdvice. Assim estou implementando uma classe 
	 * auxiliar que vai interceptar as exceções e obrigatóriamente precisa ter essa assinatura.
	 * 
	 * Essa anotação serve para dizer que é um tratador de exceções do tipo ObjectNotFoundException.
	 * 
	 */
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
		
	}

}
