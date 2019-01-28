package com.github.livaniosilva.java.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	/**definida a variavel com nome da fala a ser usada*/
	private final static String QUEUE_NAME = "livas";
	
	
	public static void main(String [] args) throws Exception{
		/**CRIANDO A CONEXÃO COM O SERVIDOR*/
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		try (
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel()){
			
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Olá, vamos testar a fila de mensageria";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("[x] enviada'"+message +"'" );
			
		}
		
		
		
		
		
		
		
		
	}
			

}
