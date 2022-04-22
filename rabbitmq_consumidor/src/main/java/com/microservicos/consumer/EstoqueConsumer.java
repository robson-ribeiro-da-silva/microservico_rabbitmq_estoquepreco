package com.microservicos.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microservicos.constants.RabbiMQConstants;
import com.microservicos.dto.EstoqueDTO;

@Component
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbiMQConstants.FILA_ESTOQUE)
	private void consumidor_estoque(EstoqueDTO estoqueDTO) {
		System.out.println("**** ESTOQUE - CONSUMIDOR 1 ****");
		System.out.println("Codigo: "+estoqueDTO.codigoproduto);
		System.out.println("Quantidade: "+estoqueDTO.quantidade);
		System.out.println("---------------------------------------");
	}
	
	@RabbitListener(queues = RabbiMQConstants.FILA_ESTOQUE)
	private void consumidor_estoque_2(EstoqueDTO estoqueDTO) {
		System.out.println("**** ESTOQUE - CONSUMIDOR 2 ****");
		System.out.println("Codigo: "+estoqueDTO.codigoproduto);
		System.out.println("Quantidade: "+estoqueDTO.quantidade);
		System.out.println("---------------------------------------");
	}

}
