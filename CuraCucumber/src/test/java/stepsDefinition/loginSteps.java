package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import stepsObject.loginPage;
import stepsObject.makeAppointmentPage;
import utils.Hooks;

public class loginSteps {

    final WebDriver driver;
    final loginPage loginPage;
    final makeAppointmentPage makeAppointment;

    public loginSteps(){
        this.driver = Hooks.driver;
        this.loginPage = new loginPage();
        this.makeAppointment = new makeAppointmentPage();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.openLoginPage("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    }

    @When("I input invalid username {string} and invalid password {string}")
    public void iInputInvalidUsernameAndInvalidPassword(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @And("I click the login button")
    public void iClickLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeMessage(String expectationMsg) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectationMsg,actualMessage);
    }

    @When("I input valid username {string} and valid password {string}")
    public void iInputValidUsernameAndValidPassword(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @Then("I should be redirected to the home page \\(Make Appointment)")
    public void iShouldBeRedirectedToHomePageMakeAppointment() {
        String actualElement = makeAppointment.getElementAppointment();
        Assert.assertEquals("Make Appointment",actualElement);

    }
}
