package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import po.BasePage;

public class InstagramHomePage extends BasePage{

        public InstagramHomePage(WebDriver driver) {
            super(driver);
        }

        public boolean isLoaded() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("NXVPg"))).isDisplayed();

    }

}
