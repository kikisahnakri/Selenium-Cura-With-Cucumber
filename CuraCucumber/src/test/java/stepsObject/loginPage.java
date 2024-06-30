package stepsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Hooks;

public class loginPage {

    public final WebDriver driver;

    public loginPage() {
        this.driver = Hooks.driver;
    }

    public By usernameField = By.xpath("//input[@id='txt-username']");
    public By passwordField = By.xpath("//input[@id='txt-password']");
    public By btnLogin = By.xpath("//button[@id='btn-login']");
    public By errorMessge = By.xpath("//p[@class='lead text-danger']");

    public void openLoginPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void inputUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(btnLogin).click();
    }

    public String getErrorMessage(){
      return driver.findElement(errorMessge).getText();
    }



}
