package atda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import po.LoginPage;
import po.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }


    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    @Test
    public void shouldLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductPage(driver).isLoaded());

    }

    @Test
    public void canNotLoginWithInvalidUserName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("standard_user", "secret");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Test");

    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/stefan/Desktop/frameworks/SeleniumYoutube/src/main/resources/drivers/chromedriver");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
