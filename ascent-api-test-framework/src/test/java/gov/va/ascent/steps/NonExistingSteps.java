package gov.va.ascent.steps;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

import com.jayway.restassured.path.json.JsonPath;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.va.ascent.util.BaseStepDef;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class NonExistingSteps extends BaseStepDef {

	private Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}T.*"); 

	@Before({"@nonexistingcalimid"})
	public void setUpREST() {
		initREST();
	}

	@Given("^Veteran has a claim Id that doesn't exist$")
	public void passHeaderInformationForVeteran(
			Map<String, String> tblHeader) throws Throwable {
		passHeaderInformation(tblHeader);
	}

	@When("claim service is called with claim Id \"([^\"]*)\" with \"([^\"]*)\"$")
	public void makerestcalltoClaimserviceusingGET(
			String strURL,String claimId ) throws Throwable {
		String newUrl = strURL.replace("{claimId}", claimId);
		invokeAPIUsingPost(newUrl, "claims.baseURL");
	}

	@Then("^the claim sercice returns message.severity of error")
	public void returnsclaimsmessageseverityoferror()
			throws Throwable {
	
		Map<String, Object> claims = JsonPath.with(strResponse).get("messages[0]");
		Assert.assertTrue(claims.get("severity").equals("ERROR"));			
	}
	
	@And ("^the claim service returns message.key of claims.claimsnotfound")
	public void returnsclaimsmessagekeyofclaimsnotfound()
			throws Throwable {
		Map<String, Object> claims = JsonPath.with(strResponse).get("messages[0]");
		Assert.assertTrue(claims.get("key").equals("claims.claimNotFound"));
	}
		
	@And ("^claims service returns message.text of error retrieving with given claimid")
	public void returnsclaimsmessagetextoferror()
			throws Throwable {
		Map<String, Object> claims = JsonPath.with(strResponse).get("messages[0]");
		Assert.assertTrue(claims.get("text").equals("Error retrieving claim with given claimId"));	
	}
	@After({"@nonexistingcalimid"})
	public void cleanUp(Scenario scenario) {
		postProcess(scenario);
	}
}
