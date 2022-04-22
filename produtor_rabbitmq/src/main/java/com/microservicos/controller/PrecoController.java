package com.microservicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicos.constants.RabbiMQConstants;
import com.microservicos.dto.PrecoDTO;
import com.microservicos.service.RabbitMQService;

@RestController
@RequestMapping("/preco")
public class PrecoController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@PutMapping
	private ResponseEntity alteraPreco(@RequestBody PrecoDTO precoDTO) {
		this.rabbitMQService.enviaMensagem(RabbiMQConstants.FILA_PRECO, precoDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

}
