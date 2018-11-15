package Pages;

import org.hamcrest.Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="link-create")
    WebElement btnCreateApp;

    @FindBy(xpath= "//button[contains(@class,'ui-corner-all done')]")
    public WebElement btnletsGetStarted;
    @FindBy(id="add-page")
    public WebElement btnAddPage;

    public void click_createApp()
    {
        btnCreateApp.click();
    }
    public void click_letsGetStarted()
    {
        btnletsGetStarted.click();
    }

}
