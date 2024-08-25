import Base.Base;
import Pages.ForgotPasswordPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class ResetPassword extends Base {
    HomePage homePage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;

    @Test(description = "Password reset check")
    public void forgotPasswordReset() throws InterruptedException {

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);

        homePage.myAccount().clickToLogin();
        loginPage.clickToForgotPassword();
        forgotPasswordPage.enterEmail("pandatest0121@gmail.com").clickToForgotPasswordButton().isResendButtonVisible();
    }
}
