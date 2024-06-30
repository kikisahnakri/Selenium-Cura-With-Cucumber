package stepsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Hooks;

public class makeAppointmentPage {
    public final WebDriver driver;

    public makeAppointmentPage() {
        this.driver = Hooks.driver;
    }

    public By verifyElementAppointment = By.xpath("//h2[.='Make Appointment']");
    public By makeAppointmentBtn = By.xpath("//a[@id='btn-make-appointment']");
    public By facilityHongkong = By.xpath("//option[.='Hongkong CURA Healthcare Center']");
    public By checboxReadmission = By.xpath("//label[@class='checkbox-inline']");
    public By programMedicaid = By.xpath("//input[@id='radio_program_medicaid']");
    public By visitDate = By.xpath("//input[@id='txt_visit_date']");
    public By commentText = By.xpath("//textarea[@id='txt_comment']");
    public By bookApointmentBtn = By.xpath("//button[@id='btn-book-appointment']");


    public String getElementAppointment(){
        return driver.findElement(verifyElementAppointment).getText();
    }


    public void clickFacilityHongkongCuraHealthcareCenter() {
        driver.findElement(facilityHongkong).click();
    }

    public void clickboxApplyForHospitalReadmission() {
        driver.findElement(checboxReadmission).click();
    }

    public void clickHealthcareProgramMedicaid() {
        driver.findElement(programMedicaid).click();
    }

    public void inputVisitDate(String date) {
        driver.findElement(visitDate).sendKeys(date);
    }

    public void inputComment(String comment) {
        driver.findElement(commentText).sendKeys(comment);
    }

    public void clickBookAppointmentBtn() {
        driver.findElement(bookApointmentBtn).click();
    }


    public void clickBtnMakeAppointment() {
        driver.findElement(makeAppointmentBtn).click();
    }

    public String getVisitDate() {
        //String message = driver.findElement(By.name("usrname")).getAttribute("validationMessage");

        return driver.findElement(visitDate).getAttribute("validationMessage");
    }



}


