import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

@Epic ("Google apps")
@Feature("Play store")
public class AppiumTest {

    public AndroidDriver<AndroidElement> driver;
    public FluentWait<WebDriver> wait;
    public DesiredCapabilities capabilities;

    {}
   // @Test
    public void testName(ITestContext context) throws MalformedURLException, InterruptedException {

        capabilities = new DesiredCapabilities();
        //capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "7.0");
        capabilities.setCapability("deviceName", "HUJAWEJ P9 lite");
        capabilities.setCapability("udid","BUC4C16B28002824");
        capabilities.setCapability("platformName", "Android");
        //Google App Store
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
       // capabilities.setCapability("appPackage", "com.android.calculator2");
       // capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("autoGrantPermissions", true);
      //  capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("newCommandInstallTimeout", 900000);
        capabilities.setCapability("androidInstallTimeout", 900000);





        this.driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4730/wd/hub"), capabilities);
        this.wait = new WebDriverWait(driver, 5)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);

        context.setAttribute("driver", this.driver);
        context.setAttribute("wait", this.wait);

      //  AndroidElement button9 = this.driver.findElementById("com.android.calculator2:id/digit_9");
     //   button9.click();


        Page page = new Page(context);
        page.isDisplayed();
        //page.searchGames();
        Thread.sleep(10000);
    }

    @Test(groups={"smoke", "regression"})
    @Story ("Fake smoke test")
    public void smokeTest(){
        System.out.println("Hello smoke");
    }

    @Test (groups={"regression"})
    @Story ("Fake regression test")
    @Description("opis")
    public void regressionTest(){
        System.out.println("Hello regression");
    }
}