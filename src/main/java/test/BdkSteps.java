package test;

import com.symphony.bdk.core.SymphonyBdk;
import com.symphony.bdk.core.auth.exception.AuthInitializationException;
import com.symphony.bdk.core.auth.exception.AuthUnauthorizedException;
import com.symphony.bdk.core.config.BdkConfigLoader;
import com.symphony.bdk.core.config.exception.BdkConfigException;
import com.symphony.bdk.core.config.model.BdkConfig;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.*;

public class BdkSteps {

    private SymphonyBdk bdk;
    private BdkConfig config;

    @Given("a bot config $config")
    public void aCounter(String config) throws BdkConfigException {
        this.config = BdkConfigLoader.loadFromClasspath(config);
    }

    @When("the bot authenticates")
    public void increasesTheCounter() throws AuthUnauthorizedException, AuthInitializationException {
        this.bdk = new SymphonyBdk(this.config);
    }

    @Then("a bot session is created")
    public void theValueOfTheCounterMustBe1Greater() {
       assertNotNull(this.bdk.botSession());
    }
}
