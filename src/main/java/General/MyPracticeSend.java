package General;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.AMQP.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MyPracticeSend {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		Channel channel= connection.createChannel();
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		
		String msg = "oh shit I m in channel";
		channel.basicPublish("", QUEUE_NAME,null, msg.getBytes("UTF-8"));
		
		System.out.println("msg sent");
		channel.close();
		connection.close();
	}
}
