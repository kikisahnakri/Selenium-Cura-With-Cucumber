package stepsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Hooks;

public class appointmentConfirmationPage {
    public final WebDriver driver;

    public appointmentConfirmationPage() {
        this.driver = Hooks.driver;
    }

    public By confirmationElement= By.xpath("//h2[.='Appointment Confirmation']");
    public By confirmInformElement = By.xpath("//p[@class='lead']");
    public By facilityField = By.xpath("//p[@id='facility']");
    public By readmissionField = By.xpath("//p[@id='hospital_readmission']");
    public By programMedicaidField = By.xpath("//p[@id='program']");
    public By visitDateField = By.xpath("//p[@id='visit_date']");
    public By commentTextField = By.xpath("//p[@id='comment']");

    public String getSuccessConfirmationAppointment(){
        return driver.findElement(confirmationElement).getText();
    }

    public String getInform(){
        return driver.findElement(confirmInformElement).getText();
    }

    public String getActualFacility(){
        return driver.findElement(facilityField).getText();
    }

    public String getActualReadmission(){
        return driver.findElement(readmissionField).getText();
    }

    public String getActualProgram(){
        return driver.findElement(programMedicaidField).getText();
    }

    public String getActualVisitDate(){
        return driver.findElement(visitDateField).getText();
    }

    public String getActualComment(){
        return driver.findElement(commentTextField).getText();
    }

}
