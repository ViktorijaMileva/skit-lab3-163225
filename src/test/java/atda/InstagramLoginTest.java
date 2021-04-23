package atda;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InstagramHomePage;
import pages.InstagramLoginPage;
import po.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class InstagramLoginTest  {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void shouldOpen() throws InterruptedException {
        InstagramLoginPage instagramLoginPage = new InstagramLoginPage(driver);
        instagramLoginPage.open();
        assertTrue(instagramLoginPage.isLoaded());
    }

    @Test
    public void shouldLogin() throws InterruptedException{
        InstagramLoginPage instagramLoginPage = new InstagramLoginPage(driver);
        instagramLoginPage.open();
        assertTrue(instagramLoginPage.isLoaded());
        instagramLoginPage.login("user1", "user_password");
        assertTrue(new InstagramHomePage(driver).isLoaded());
    }

    @Test
    public void canNotLoginWithInvalidArguments() throws InterruptedException{
        InstagramLoginPage instagramLoginPage = new InstagramLoginPage(driver);
        instagramLoginPage.open();
        assertTrue(instagramLoginPage.isLoaded());
        instagramLoginPage.login("user1", "password");
        String errorMessage = instagramLoginPage.getErrorMessage();
        assertEquals(errorMessage, "Don't have an account? Sign up");
    }

    @Test
    public void canNotLoginWithEmptyArguments() throws InterruptedException{
        InstagramLoginPage instagramLoginPage = new InstagramLoginPage(driver);
        instagramLoginPage.open();
        assertTrue(instagramLoginPage.isLoaded());
        instagramLoginPage.login("", "user_password");
        instagramLoginPage.loginButton();
    }


    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/Viktorija/Desktop/skit-lab3/chromedriver_win32/chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
