import Base.Base;
import Pages.HomePage;
import org.testng.annotations.Test;

public class Search extends Base {
    HomePage homePage;

    @Test(description = "Product search control")
    public void productSearch() {
        homePage = new HomePage(driver);

        homePage.searchBox("Telefon");
    }
}
