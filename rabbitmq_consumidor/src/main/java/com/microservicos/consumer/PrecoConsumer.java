package com.microservicos.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microservicos.constants.RabbiMQConstants;
import com.microservicos.dto.EstoqueDTO;
import com.microservicos.dto.PrecoDTO;

@Component
public class PrecoConsumer {
	
	@RabbitListener(queues = RabbiMQConstants.FILA_PRECO)
	private void consumidor_preco(PrecoDTO precoDTO) {
		System.out.println("**** PREÇO - CONSUMIDOR 1 ****");
		System.out.println("Codigo: "+precoDTO.codigoproduto);
		System.out.println("Preço: "+precoDTO.preco);
		System.out.println("---------------------------------------");
	}
	
	@RabbitListener(queues = RabbiMQConstants.FILA_PRECO)
	private void consumidor_preco_2(PrecoDTO precoDTO) {
		System.out.println("**** PREÇO - CONSUMIDOR 2 ****");
		System.out.println("Codigo: "+precoDTO.codigoproduto);
		System.out.println("Preço: "+precoDTO.preco);
		System.out.println("---------------------------------------");
	}

}
