import Base.Base;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;


public class Login extends Base {
    HomePage homePage;
    LoginPage loginPage;

    @Test(description = "Successful user login")
    public void loginTest() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.myAccount().clickToLogin();
        loginPage.writeEmail("pandatest0121@gmail.com")
                .writePassword("Pandas2121..hh")
                .clickLogin();
    }

    @Test(description = "Unsuccessful user login")
    public void unsuccessfulLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.myAccount().clickToLogin();
        loginPage.writeEmail("pandatest0121@gmail.com")
                .writePassword("Pandahh")
                .clickLogin()
                .verifyPasswordErrorMessage();
    }

    @Test(description = "Forgot my password control")
    public void forgotPasswordControl() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.myAccount().clickToLogin();
        loginPage.clickToForgotPassword();
    }
}