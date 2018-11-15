package Tests;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class CodingTest {
    
    @Test()
    public void createAppTest() {
        WebDriver driver=Driver.getDriver();
        HomePage homePage=PageFactory.initElements(driver, HomePage.class);
        homePage.loadPage("http://quickfuseapps.com");
        homePage.click_createApp();
        homePage.click_letsGetStarted();
        CreateAppPage createAppPage=PageFactory.initElements(driver, CreateAppPage.class);
        createAppPage.click_newApp();
        createAppPage.enter_appName("myApp");
        createAppPage.click_messaging();
        createAppPage.click_sendSms();
        createAppPage.enter_phone("9876543210");
        createAppPage.enter_text("Test");
        createAppPage.join_startToSMS();
        createAppPage.click_sendEmail();
        createAppPage.join_smsToEmail();
        createAppPage.click_basic();
        createAppPage.click_exitNode(400,100);
        createAppPage.join_smsToExit();
        createAppPage.click_exitNode(400,400);
        createAppPage.join_EmailToExit("west",5);
        createAppPage.click_exitNode(1150,400);
        createAppPage.join_EmailToExit("east",6);
    }


}