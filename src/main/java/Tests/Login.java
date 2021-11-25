package Tests;

import Pages.LoginPage;
import Pages.VeryficationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    private String login = "***"; //please enter your correct login
    private String incorrectLogin = "***"; //please enter incorrect login
    private String password = "***"; //please enter your correct password


    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.nazwa.pl/zaloguj-sie");
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void loginPositive() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login, password);
        VeryficationPage veryficationPage = new VeryficationPage(driver);
        veryficationPage.assertionLoginPositive();
    }

    @Test
    public void loginNegative() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(incorrectLogin, password);
        loginPage.assertionLoginNegative();
    }
}
