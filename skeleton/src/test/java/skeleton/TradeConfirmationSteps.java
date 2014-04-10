package skeleton;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:spring-test-context.xml"})
public class TradeConfirmationSteps {
    @Resource(name="inboundTradeEventSender")
    private JmsTemplate inboundTradeEventSender;
    @Resource(name="clearingHouse")
    private JmsTemplate clearingHouse;

    @Given("^A new trade between the bank and counterparty$")
    public void A_new_trade_between_the_bank_and_counterparty() throws Throwable {
       inboundTradeEventSender.convertAndSend("hello");
    }

    @When("^the trade is captured$")
    public void the_trade_is_captured() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^it sent to clearing house for matching$")
    public void it_sent_to_clearing_house_for_matching() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
