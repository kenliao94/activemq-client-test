package ActiveClient;

import org.apache.activemq.ActiveMQConnectionFactory;

import jakarta.jms.*;

/**
 * A Simple example that connects to the ActiveMQ broker with JMS 2.0, send and receive message
 */
public class TestActiveMqSDK implements Example {

    private final static String WIRE_LEVEL_ENDPOINT
            = "<Your broker endpoint either remote or localhost>";
    private final static String ACTIVE_MQ_USERNAME = "<username>";
    private final static String ACTIVE_MQ_PASSWORD = "<password>";

    public void run() throws JMSException {
        // Create a connection factory.
        final ActiveMQConnectionFactory connectionFactory =
            new ActiveMQConnectionFactory(WIRE_LEVEL_ENDPOINT);
        // Pass the sign-in credentials.
        connectionFactory.setUserName(ACTIVE_MQ_USERNAME);
        connectionFactory.setPassword(ACTIVE_MQ_PASSWORD);

        // Send a message
        try (JMSContext context = connectionFactory.createContext();) {
            context.createProducer().send(context.createQueue("MyQueueV3")," Hello, welcome to AmazonMQ using JMS 3.0!");
            JMSConsumer consumer = context.createConsumer(context.createQueue("MyQueueV3"));
            // String text = consumer.receiveBody(String.class); // <- This throws unsupported action
            Message message = consumer.receive();
            final TextMessage consumerTextMessage = (TextMessage) message;
            System.out.println("Message: " + consumerTextMessage.getText());
        }
    }
}