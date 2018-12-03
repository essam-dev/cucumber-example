package hellocucumber;

import static org.junit.Assert.assertEquals;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".compareTo(today) == 0 ? "TGIF" : "Nope";
    }
}

public class Stepdefs {
	private String today;
    private String actualAnswer;

	@Given("^Today is \\\"([^\\\"]*)\\\"$")
	public void today_is(String today) throws Exception {
		this.today = today;
	}

	@When("^I ask whether it's Friday yet$")
	public void i_ask_whether_it_s_Friday_yet() throws Exception {
		this.actualAnswer = IsItFriday.isItFriday(today);
	}

	@Then("^I should be told \"([^\"]*)\"$")
	public void i_should_be_told(String expectedAnswer) throws Exception {
		assertEquals(expectedAnswer, actualAnswer);
	}
	
}