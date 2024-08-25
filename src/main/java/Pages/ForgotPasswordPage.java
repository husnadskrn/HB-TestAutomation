package Pages;

import Base.Data;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage extends Data {

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("I forgot my password email login")
    public ForgotPasswordPage enterEmail(String email) {
        driver.findElement(By.id("txtForgotPassEmail")).sendKeys(email);
        return this;
    }

    @Step("I forgot my password email login")
    public ForgotPasswordPage clickToForgotPasswordButton() {
        driver.findElement(By.id("btnForgotPass")).click();
        return this;
    }

    @Step("Resend Button Visibility control")
    public boolean isResendButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement resendButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSendAgain")));
            return resendButton.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

}
