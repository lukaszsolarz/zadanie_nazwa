package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VeryficationPage {
    WebDriver driver;

    public VeryficationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By twoStepVerificationWindow = By.xpath("//div[@id='PK_LoginByAuthenticationCode']/h2");

    public VeryficationPage assertionLoginPositive() {

        WebElement veryfication = driver.findElement(twoStepVerificationWindow);
        Assertions.assertTrue(veryfication.getText().contains("Weryfikacja dwuetapowa"), "invalid login data was provided");
        return new VeryficationPage(driver);
    }

}