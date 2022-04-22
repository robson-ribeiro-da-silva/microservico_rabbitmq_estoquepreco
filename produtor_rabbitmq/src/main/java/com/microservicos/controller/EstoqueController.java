package com.microservicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicos.constants.RabbiMQConstants;
import com.microservicos.dto.EstoqueDTO;
import com.microservicos.service.RabbitMQService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDTO) {
		
		this.rabbitMQService.enviaMensagem(RabbiMQConstants.FILA_ESTOQUE, estoqueDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

}
