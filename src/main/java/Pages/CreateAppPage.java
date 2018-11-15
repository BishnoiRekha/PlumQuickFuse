package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CreateAppPage extends BasePage {
    public CreateAppPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="add-page")
    public WebElement btnAddPage;

    @FindBy(css=".indented.submitonenter")
    public WebElement edtBoxPageName;


    String startNodeXpath="(//div[contains(@class,'module-title') and contains(text(),'Start')]/ancestor::div[contains(@class,'start')]//div[contains(@class,'syn-node ui-draggable')])[2]";
    String receptorNodeXpath="//div[contains(@class,'module-title') and contains(text(),'%s')]/ancestor::div[contains(@class,'syn-module')]//div[contains(@class,'syn-receptor')]";
    String eastNodeXpath="//div[contains(@class,'module-title') and contains(text(),'%s')]/ancestor::div[contains(@class,'syn-module')]//div[contains(@class,'syn-node syn-node-attached-e')]";
    String westNodeXpath="//div[contains(@class,'module-title') and contains(text(),'%s')]/ancestor::div[contains(@class,'syn-module')]//div[contains(@class,'syn-node syn-node-attached-w')]";
    String exitNode="//div[contains(@class,'module-title') and contains(text(),'Exit')]/ancestor::div[contains(@class,'syn-module') and @id='module-4']//div[contains(@class,'syn-receptor')]";
    String exitEmailNode="//div[contains(@class,'module-title') and contains(text(),'Exit')]/ancestor::div[contains(@class,'syn-module') and @id='module-%s']//div[contains(@class,'syn-receptor')]";

 //   String emailEastNodeXpath="//div[contains(@class,'module-title') and contains(text(),'Email')]/ancestor::div[contains(@class,'syn-module')]//div[contains(@class,'syn-node syn-node-attached-e')]";
 //   String emailWestNodeXpath="//div[contains(@class,'module-title') and contains(text(),'Email')]/ancestor::div[contains(@class,'syn-module')]//div[contains(@class,'syn-node syn-node-attached-w')]";
  //  String toEmailNodeXpath="//div[contains(@class,'module-title') and contains(text(),'Email')]/ancestor::div[contains(@class,'syn-module')]//div[contains(@class,'syn-receptor')]";


    String btnCreateXpath="//button[contains(@class,'ui-corner-all ui-button ui-state')]";
    String messagingXpath = "//a[contains(text(),'Messaging')]";
    String basicXpath = "//a[contains(text(),'Basic')]";
   String sendSmsXpath="(//li[@class='module-item ui-widget-content ui-corner-all module-item-green ui-draggable'])[3]";
    String sendEmailXpath="(//li[@class='module-item ui-widget-content ui-corner-all module-item-green ui-draggable'])[2]";

    String exitElemXpath="//li[@class='module-item ui-widget-content ui-corner-all module-item-red ui-draggable']";

    String paneXpath="//div[@class='ui-page-panel ui-tabs-panel ui-widget-content ui-droppable']";

    String phoneNoXpath="//textArea[@name='phone_constant']";
    String smsTextAreaXpath="//div[contains(@class,'module-title') and contains(text(),'SMS')]/ancestor::div[contains(@class,'syn-module')]//textArea[contains(@class,'syn-autoexpand syn-constant syn-autogrow')]";

    public void click_newApp()
    {
        btnAddPage.click();
    }
    public void enter_appName(String name)
    {
        edtBoxPageName.sendKeys(name);
        edtBoxPageName.sendKeys(Keys.ENTER);
    }
    public void click_create()
    { WebElement btnCreate=wrapper.findElementByXpath(btnCreateXpath);
        btnCreate.click();
    }
    public void click_messaging()
    {
        WebElement messaging=wrapper.findElementByXpath(messagingXpath);
        messaging.click();
    }
    public void click_basic()
    {
        WebElement basic=wrapper.findElementByXpath(basicXpath);
        basic.click();
    }
    public void click_sendSms()
    {
        WebElement messaging=wrapper.findElementByXpath(sendSmsXpath);
        WebElement pane=wrapper.findElementByXpath(paneXpath);
        wrapper.dragAndDropBy(messaging,600,100);
        wrapper.waitFor(3000);
    }

    public void click_exitNode(int startPos,int endPos)
    {
        wrapper.waitForElemPresence(By.xpath(exitElemXpath));
        WebElement messaging=wrapper.findElementByXpath(exitElemXpath);
        wrapper.dragAndDropBy(messaging,startPos,endPos);
        wrapper.waitFor(3000);
    }

    public void click_sendEmail()
    {
        WebElement messaging=wrapper.findElementByXpath(sendEmailXpath);
        WebElement pane=wrapper.findElementByXpath(paneXpath);
        wrapper.dragAndDropBy(messaging,800,250);
    }

    public void join_startToSMS()
    {   wrapper.waitForElemPresence(By.xpath(String.format(receptorNodeXpath,"SMS")));
        wrapper.waitFor(5000);
        WebElement start=wrapper.findElementByXpath(startNodeXpath);
        WebElement end=wrapper.findElementByXpath(String.format(receptorNodeXpath,"SMS"));
        wrapper.dragAndDrop(start,end);
    }
    public void join_smsToEmail()
    {
        WebElement smsEastNode=wrapper.findElementByXpath(String.format(eastNodeXpath,"SMS"));
        WebElement emailReceptorNodeXpath=wrapper.findElementByXpath(String.format(receptorNodeXpath,"Email"));
        wrapper.dragAndDrop(smsEastNode,emailReceptorNodeXpath);
    }

    public void join_smsToExit()
    {
        WebElement smsWestNode=wrapper.findElementByXpath(String.format(westNodeXpath,"SMS"));
        WebElement exitReceptorNodeXpath=wrapper.findElementByXpath(String.format(receptorNodeXpath,"Exit"));
        wrapper.dragAndDrop(smsWestNode,exitReceptorNodeXpath);
    }

    public void join_EmailToExit(String nodeLocation,int exitModuleIndex)
    {WebElement smsNode;
        if(nodeLocation.equalsIgnoreCase("east"))
            smsNode=wrapper.findElementByXpath(String.format(eastNodeXpath,"Email"));
        else
            smsNode=wrapper.findElementByXpath(String.format(westNodeXpath,"Email"));
        WebElement exitReceptorNodeXpath=wrapper.findElementByXpath(String.format(exitEmailNode,exitModuleIndex));
        wrapper.dragAndDrop(smsNode,exitReceptorNodeXpath);
    }

    public void enter_phone(String phoneNo)
    {
        wrapper.waitForElemPresence(By.xpath(phoneNoXpath));
        wrapper.findElementByXpath(phoneNoXpath).sendKeys(phoneNo);

    }

    public void enter_text(String text)
    {
        wrapper.waitForElemPresence(By.xpath(smsTextAreaXpath));
        wrapper.findElementByXpath(smsTextAreaXpath).sendKeys(text);

    }
}
