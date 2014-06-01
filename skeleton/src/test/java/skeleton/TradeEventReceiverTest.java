package skeleton;

import org.junit.Test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import static org.mockito.Mockito.*;

public class TradeEventReceiverTest {

    private TradeEventReceiver tradeEventReceiver = new TradeEventReceiver();

    @Test
    public void messageReceivedIsDisplayed() throws Exception {
        TextMessage textMessage = createDummyTextMessageWithContent();

        tradeEventReceiver.onMessage(textMessage);

        verify(textMessage).getText();
    }

    @Test
    public void noActionIsTakenWhenMessageTypeIsNotTextMessage() {
        Message streamMessage = mock(StreamMessage.class);

        tradeEventReceiver.onMessage(streamMessage);

        verifyZeroInteractions(streamMessage);
    }

    private TextMessage createDummyTextMessageWithContent() throws JMSException {
        TextMessage message = mock(TextMessage.class);
        when(message.getText()).thenReturn("Hello World");
        return message;
    }
}