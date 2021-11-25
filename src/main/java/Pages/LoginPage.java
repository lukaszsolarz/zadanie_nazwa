package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By inputClientLogin = By.xpath("//input[@id='clientLogin']");
    private By inputClientPass = By.xpath("//input[@id='clientPass']");
    private By buttonSubmit = By.xpath("//input[@value='Zaloguj się']");
    private By veryficationStatusHeader = By.xpath("//table[@class='sub_info_new alert']//div[@class='message-text']");

    public LoginPage login(String login, String password) {
        WebElement clientLogin = driver.findElement(inputClientLogin);
        clientLogin.sendKeys(login);
        WebElement clientPass = driver.findElement(inputClientPass);
        clientPass.sendKeys(password);
        WebElement submit = driver.findElement(buttonSubmit);
        submit.click();
        return new LoginPage(driver);
    }

    public LoginPage assertionLoginNegative() {
        WebElement veryficationStatus = driver.findElement(veryficationStatusHeader);
        Assertions.assertTrue(veryficationStatus.getText().contains("Nieprawidłowy login lub hasło."), "problem with incorrect login");
        return new LoginPage(driver);
    }
}
