package Work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MyPracticeWorker {

	  private static final String TASK_QUEUE_NAME = "task_queue";

	
	  public static void main(String[] argv) throws Exception {
		    ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    final Connection connection = factory.newConnection();
		    final Channel channel = connection.createChannel();
		    
//		    non-durable, exclusive, autodelete queue
//		    String queueName = channel.queueDeclare().getQueue();
		    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		    

}
}