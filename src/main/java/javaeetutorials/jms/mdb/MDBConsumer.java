package javaeetutorials.jms.mdb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:jboss/jms/javaee"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class MDBConsumer implements MessageListener {

  @Override
  public void onMessage(Message message) {
    try {
      System.out.println("From MDBs: " + ((TextMessage) message).getText());
    } catch (JMSException e) {
      throw new RuntimeException(e);
    }
  }
}