package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import po.BasePage;

public class InstagramLoginPage extends BasePage {
    public InstagramLoginPage(WebDriver driver){
        super(driver);
    }
    public void open(){
        driver.get("https://www.instagram.com/");
    }
    public boolean isLoaded() throws InterruptedException{
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).isDisplayed();
    }

    public void login(String username, String password)throws InterruptedException{
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(5000);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.className("sqdOP")).click();
        Thread.sleep(5000);
    }

    public Object loginButton() throws InterruptedException{
        WebElement loginButton = driver.findElement(By.className("sqdOP"));
        Thread.sleep(5000);
        if ((loginButton.isEnabled()) == false) {
            return loginButton;
        }
        else {
            return loginButton.isDisplayed();
        }
    }

    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.xpath("//p"));
        return errorPage.getText();
    }
}
