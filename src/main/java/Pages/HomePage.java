package Pages;

import Base.Data;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Data {
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the home page login button")
    public HomePage myAccount() {
        driver.findElement(By.id("myAccount")).click();
        return this;
    }

    @Step("Click the login button in the dropdown menu")
    public HomePage clickToLogin() {
        WebElement loginButton = driver.findElement(By.id("login"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButton);
        return this;
    }

    @Step("Click the login button in the dropdown menu")
    public HomePage clickToSearchBox() {
        driver.findElement(By.cssSelector(".searchBoxOld-yDJzsIfi_S5gVgoapx6f")).click();
        return this;
    }

    @Step("Home page product search")
    public HomePage searchBox(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".searchBoxOld-P2GCKq3V7DvEXIgWsSCP")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text + "';", searchBox);
        return this;
    }
}
