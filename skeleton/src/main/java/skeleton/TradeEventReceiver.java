package skeleton;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TradeEventReceiver implements MessageListener {
    private static final String ERROR_LOG = "ERROR";

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println(convertToTextMessage(message).getText());
            } catch (JMSException e) {
                System.out.println(ERROR_LOG);
                e.printStackTrace();
            }
        }
    }

    private TextMessage convertToTextMessage(Message message) {
        return ((TextMessage) message);
    }
    //This class should read from the inbound.trade.events queue,, print it out so we know that we have received it,
    //then place the message on the clearing house queue so that the tests passes
}


