package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import stepsObject.appointmentConfirmationPage;
import stepsObject.makeAppointmentPage;
import utils.Hooks;

public class appointmentSteps {

    final WebDriver driver;
    final makeAppointmentPage appointmentPage;
    final appointmentConfirmationPage confirmationPage;

    public appointmentSteps(){
        this.driver = Hooks.driver;
        this.appointmentPage = new makeAppointmentPage();
        this.confirmationPage = new appointmentConfirmationPage();
    }

    @And("I clik Hongkong CURA Healthcare Center on facility")
    public void iClickFacility() {
       appointmentPage.clickFacilityHongkongCuraHealthcareCenter();
    }

    @And("I click the checkbox on Apply for hospital readmission")
    public void iClickTheCheckbox() {
        appointmentPage.clickboxApplyForHospitalReadmission();
    }

    @And("I click the radio button Medicaid on Healthcare Program")
    public void iClickTheRadioButton() {
        appointmentPage.clickHealthcareProgramMedicaid();
    }

    @And("I leave the date field empty")
    public void iLeaveTheDateFieldEmpty() {
        System.out.println("without input field date");
    }

    @And("I input comment {string}")
    public void iInputComment(String comment) {
        appointmentPage.inputComment(comment);
    }

    @When("I click the make appointment button")
    public void iClickTheMakeAppointmentButton() {
        appointmentPage.clickBookAppointmentBtn();
    }

    @Then("I should see an error {string} indicating the date field is required")
    public void iShouldSeeAnErrorMessageIndicatingTheDateFieldIsRequired(String message) {
       String errorMessage = appointmentPage.getVisitDate();
       Assert.assertEquals(message,errorMessage);
    }

    @And("I input the date {string}")
    public void iInputTheDate(String date) {
        appointmentPage.inputVisitDate(date);
    }

    @Then("I should be redirected to the Appointment Confirmation page")
    public void iShouldBeRedirectedToTheAppointmentConfirmationPage() {
        String resultH2Element = confirmationPage.getSuccessConfirmationAppointment();
        Assert.assertEquals("Appointment Confirmation",resultH2Element);

        String resultPElement = confirmationPage.getInform();
        Assert.assertEquals("Please be informed that your appointment has been booked as following:",resultPElement);

        String actualFacility = confirmationPage.getActualFacility();
        Assert.assertEquals("Hongkong CURA Healthcare Center",actualFacility);

        String actualReadmission= confirmationPage.getActualReadmission();
        Assert.assertEquals("Yes",actualReadmission);

        String actualProgram= confirmationPage.getActualProgram();
        Assert.assertEquals("Medicaid",actualProgram);

        String actualVisitDate= confirmationPage.getActualVisitDate();
        Assert.assertEquals("18/06/2024",actualVisitDate);

        String actualComment= confirmationPage.getActualComment();
        Assert.assertEquals("ini comment untuk testing",actualComment);
    }

    @And("I click the button Make Appointment")
    public void iClickTheButtonMakeAppointment() {
        appointmentPage.clickBtnMakeAppointment();
    }

    @Then("I should see form Make Appointment")
    public void iShouldSeeFormMakeAppointment() {
        String actual = appointmentPage.getElementAppointment();
        Assert.assertEquals("Make Appointment",actual);
    }
}
