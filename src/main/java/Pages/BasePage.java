package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public final Wrapper wrapper;

    public BasePage(WebDriver driver) {
        wrapper=new Wrapper(driver);
    }

    public void loadPage(String url)
    {
        wrapper.loadPage(url);
    }
    public void closeBrowser()
    {
        wrapper.closeBrowser();
    }
}
