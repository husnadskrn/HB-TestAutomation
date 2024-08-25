package Pages;

import Base.Data;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends Data {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Email field is filled")
    public LoginPage writeEmail(String mail) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("txtUserName")).sendKeys(mail);
        return this;
    }

    @Step("Password field is filled")
    public LoginPage writePassword(String password) {
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        return this;
    }

    @Step("Login button is clicked")
    public LoginPage clickLogin() {
        driver.findElement(By.id("btnLogin")).click();
        return this;
    }

    @Step("Incorrect password entered")
    public LoginPage verifyPasswordErrorMessage() throws InterruptedException {
        Thread.sleep(2000);
        String value = driver.findElement(By.xpath("div[class='hb-AxmME gSSrVL sswybjwqzfk']")).getText();
        Assert.assertEquals(value, "Girdiğiniz şifre eksik veya hatalı. Kontrol edip tekrar deneyin.");
        return this;
    }

    @Step("Click on the forgot my password button")
    public LoginPage clickToForgotPassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span[role='presentation']")).click();
        return this;
    }
}
