import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void init() {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("browserVersion", "67");
//        chromeOptions.setCapability("platformName", "Windows 10");
//        try {
//            driver = new RemoteWebDriver(new URL("http://13.49.159.31:1234"), chromeOptions);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        System.setProperty("chromedriver --whitelisted-ips", "");
    }

//    @Test(testName = "check registration")
//    public void submitFormRegistration(){
//        driver.get(Utils.SIGN_UP_URL);
//        WebFormLogIn webForm = new WebFormLogIn(driver);
//        webForm.enterLogin();
//        webForm.enterPassword();
//        webForm.pressSubmitButton();
//    }

    @Test(testName = "Successfully authorization")
    public void submitFormLogIn(){
        driver.get(Utils.LOG_IN_URL);
        PageLogIn webForm = new PageLogIn(driver);
        webForm.enterLogin();
        webForm.enterPassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.pressSubmitButton();
        Assert.assertNotNull(driver.manage().getCookieNamed("accessToken"));
    }

    @AfterSuite
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}