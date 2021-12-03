import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final WebDriver driver = new ChromeDriver();
    private static final String VALID_LOGIN = "kolya.sfadar";
    private static final String EXIST_LOGIN = "vanya.semenovich";
    private static final String EXIST_EMAIL = "ivan@gmail.com";
    private static final String VALID_PASSWORD = "12345678";
    private static final String VALID_FIRST_NAME = "Vadimchik";
    private static final String VALID_LAST_NAME = "Sidorovich";
    private static final String VALID_EMAIL = "dasdasd@mail.ru";
    private static final String VALID_PHONE_NUMBER = "+375294468732";

    @BeforeSuite
    public void init() {
        // ChromeDriver location set up in URL class
        System.setProperty("webdriver.chrome.driver", URL.CHROME_DRIVER_LOCATION);
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

    @SneakyThrows
    @Test(testName = "Failed registration, invalid login")
    public void submitFormRegister_shouldExceptError_whenDataInvalid() {
        driver.get(URL.SIGN_UP_PAGE);
        PageRegister webForm = new PageRegister(driver);
        String invalidLogin = "AsadasФФФ";
        webForm.loginInput.sendKeys(invalidLogin);
        webForm.passwordInput.sendKeys(VALID_PASSWORD);
        webForm.passwordRepeatInput.sendKeys(VALID_PASSWORD);
        webForm.firstNameInput.sendKeys(VALID_FIRST_NAME);
        webForm.lastNameInput.sendKeys(VALID_LAST_NAME);
        webForm.emailInput.sendKeys(VALID_EMAIL);
        webForm.phoneInput.sendKeys(VALID_PHONE_NUMBER);
        webForm.btnRegister.click();
        try {
            driver.findElement(new By.ByXPath("//h3[contains(@class, 'error-message')]"));
            Assert.assertTrue(true, "Error message exist");
        } catch (Throwable anyException) {
            anyException.printStackTrace();
            Assert.fail("Data invalid for registration.");
        }
    }

    @SneakyThrows
    @Test(testName = "Failed registration, exist login")
    public void submitFormRegister_shouldExceptError_whenExistLogin() {
        driver.get(URL.SIGN_UP_PAGE);
        PageRegister webForm = new PageRegister(driver);
        webForm.loginInput.sendKeys(EXIST_LOGIN);
        try {
            driver.findElement(new By. ByXPath("//span[contains(@class, 'login-error')]"));
            Assert.assertTrue(true, "Error message exist");
        } catch (Throwable anyException) {
            LOGGER.error(anyException);
            Assert.fail("Login already exist.");
        }
    }

    @SneakyThrows
    @Test(testName = "Failed registration, exist email")
    public void submitFormRegister_shouldExceptError_whenExistEmail() {
        driver.get(URL.SIGN_UP_PAGE);
        PageRegister webForm = new PageRegister(driver);
        webForm.emailInput.sendKeys(EXIST_EMAIL);
        try {
            driver.findElement(new By. ByXPath("//span[contains(@class, 'email-error')]"));
            Assert.assertTrue(true, "Error message exist");
        } catch (Throwable anyException) {
            LOGGER.error(anyException);
            Assert.fail("Login already exist.");
        }
    }

    @SneakyThrows
    @Test(testName = "Failed registration, invalid first name")
    public void submitFormRegister_shouldExceptError_whenFirstNameInvalid() {
        driver.get(URL.SIGN_UP_PAGE);
        PageRegister webForm = new PageRegister(driver);
        webForm.loginInput.sendKeys(VALID_LOGIN);
        webForm.passwordInput.sendKeys(VALID_PASSWORD);
        webForm.passwordRepeatInput.sendKeys(VALID_PASSWORD);
        String invalidName = "Eugene12312";
        webForm.firstNameInput.sendKeys(invalidName);
        webForm.lastNameInput.sendKeys(VALID_LAST_NAME);
        webForm.emailInput.sendKeys(VALID_EMAIL);
        webForm.phoneInput.sendKeys(VALID_PHONE_NUMBER);
        webForm.btnRegister.click();
        try {
            driver.findElement(new By.ByXPath("//h3[contains(@class, 'error-message')]"));
            Assert.assertTrue(true, "Error message exist");
        } catch (Throwable anyException) {
            LOGGER.error(anyException);
            Assert.fail("Data invalid first Name registration.");
        }
    }

    @SneakyThrows
    @Test(testName = "Failed registration, invalid last name")
    public void submitFormRegister_shouldExceptError_whenLastNameInvalid() {
        driver.get(URL.SIGN_UP_PAGE);
        PageRegister webForm = new PageRegister(driver);
        webForm.loginInput.sendKeys(VALID_LOGIN);
        webForm.passwordInput.sendKeys(VALID_PASSWORD);
        webForm.passwordRepeatInput.sendKeys(VALID_PASSWORD);
        webForm.firstNameInput.sendKeys(VALID_FIRST_NAME);
        String invalidName = "432Nikiforov1";
        webForm.lastNameInput.sendKeys(invalidName);
        webForm.emailInput.sendKeys(VALID_EMAIL);
        webForm.phoneInput.sendKeys(VALID_PHONE_NUMBER);
        webForm.btnRegister.click();
        try {
            driver.findElement(new By.ByXPath("//h3[contains(@class, 'error-message')]"));
            Assert.assertTrue(true, "Error message exist");
        } catch (Throwable anyException) {
            LOGGER.error(anyException);
            Assert.fail("Data invalid last name registration.");
        }
    }

    @SneakyThrows
    @Test(testName = "Failed registration, invalid email")
    public void submitFormRegister_shouldExceptError_whenEmailInvalid() {
        driver.get(URL.SIGN_UP_PAGE);
        PageRegister webForm = new PageRegister(driver);
        webForm.loginInput.sendKeys(VALID_LOGIN);
        webForm.passwordInput.sendKeys(VALID_PASSWORD);
        webForm.passwordRepeatInput.sendKeys(VALID_PASSWORD);
        webForm.firstNameInput.sendKeys(VALID_FIRST_NAME);
        webForm.lastNameInput.sendKeys(VALID_LAST_NAME);
        String invalidEmail = "emailWithoutDog";
        webForm.emailInput.sendKeys(invalidEmail);
        webForm.phoneInput.sendKeys(VALID_PHONE_NUMBER);
        webForm.btnRegister.click();
        try {
            driver.findElement(new By.ByXPath("//h3[contains(@class, 'error-message')]"));
            Assert.assertTrue(true, "Error message exist");
        } catch (Throwable anyException) {
            LOGGER.error(anyException);
            Assert.fail("Data invalid email registration.");
        }
    }

    @Test(testName = "Successfully authorization")
    public void submitFormLogIn_shouldSubmit_whenUserExist() {
        driver.get(URL.LOG_IN_PAGE);
        PageLogIn webForm = new PageLogIn(driver);
        webForm.enterLogin();
        webForm.enterPassword();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.pressSubmitButton();
        Assert.assertNotNull(driver.manage().getCookieNamed("accessToken"));
        Assert.assertTrue(driver.getCurrentUrl().contains(URL.PROFILE_PAGE));
    }

    @Test(testName = "Failed authorization")
    public void submitFormLogIn_shouldFailLogIn_whenPasswordIsIncorrect() {
        driver.get(URL.LOG_IN_PAGE);
        PageLogIn webForm = new PageLogIn(driver);
        webForm.enterLogin();
        webForm.enterIncorrectPassword();
        LOGGER.info("INFO");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.pressSubmitButton();
        Assert.assertNull(driver.manage().getCookieNamed("accessToken"));

        Assert.assertFalse(driver.getCurrentUrl().contains(URL.PROFILE_PAGE));
        Assert.assertEquals(driver.getCurrentUrl(), URL.LOG_IN_COMMAND);
        checkOnErrorMessageExist();
    }

    @AfterSuite
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}