package ActiveMQ2.TopicModel;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import java.text.DecimalFormat;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscriber {

    private static String brokerURL = "tcp://192.168.131.135:61616";
    private transient ConnectionFactory factory;
    private transient Connection connection;
    private transient Session session;
    private transient Destination destination;
    private transient MessageConsumer messageConsumer;

    public Subscriber() throws JMSException {
        factory = new ActiveMQConnectionFactory(brokerURL);
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        destination = session.createTopic("STOCKS.topic" );
        messageConsumer = session.createConsumer(destination);
    }

    public MessageConsumer getMessageConsumer() {
        return messageConsumer;
    }

    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws JMSException {
        Subscriber consumer1 = new Subscriber();
        consumer1.messageConsumer.setMessageListener(new Listener());

        Subscriber consumer2 = new Subscriber();
        consumer2.messageConsumer.setMessageListener(new Listener());

        Subscriber consumer3 = new Subscriber();
        consumer3.messageConsumer.setMessageListener(new Listener());
    }

    private static class Listener implements MessageListener {

        public void onMessage(Message message) {
            try {
                MapMessage map = (MapMessage)message;
                String topic = map.getString("topic");
                double price = map.getDouble("price");
                double offer = map.getDouble("offer");
                boolean up = map.getBoolean("up");
                DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
                System.out.println(topic + "\t" + df.format(price) + "\t" + df.format(offer) + "\t" + (up?"up":"down"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}