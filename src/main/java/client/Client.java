package ActiveClient;

import jakarta.jms.*;


public class Client {
    public static void main(String[] args) throws JMSException {
        Example example = new TestActiveMqSDK();
        example.run();
    }
}