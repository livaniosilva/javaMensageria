package com.github.livaniosilva.java.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Receiver {
	
	/** DEFININDO O NOME DA FILA PRA RECEPTOR DE MENSAGEM*/
	private final static String QUEUE_NAME = "livas";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] esperando pela mensagem. pra sair, aperte CTRL+C");
	    
	    DeliverCallback deliverCallBack = (consumerTag, delivery)-> {
	    	 String message = new String(delivery.getBody(), "UTF-8");
	            System.out.println(" [x] Received '" + message + "'");
	    };
	    channel.basicConsume(QUEUE_NAME, true, deliverCallBack, consumerTag -> { });
	    
	  }
	

}
