import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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

    private boolean isCleanUpRequired;

    @BeforeSuite
    public void init() {
        System.setProperty("webdriver.chrome.driver", URL.CHROME_DRIVER_LOCATION);
    }

    @BeforeMethod
    public void initTest() {
        LOGGER.info("INIT");
        isCleanUpRequired = true;
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
        isCleanUpRequired = false;
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
        isCleanUpRequired = false;
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
        isCleanUpRequired = false;
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
        isCleanUpRequired = false;
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
        isCleanUpRequired = false;
    }

    //TODO: FAILED
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
        isCleanUpRequired = false;
    }

    @Test(testName = "Successfully authorization")
    public void submitFormLogIn_shouldSubmit_whenUserExist() {
        driver.get(URL.LOG_IN_PAGE);
        PageLogIn webForm = new PageLogIn(driver);
        webForm.enterLogin();
        webForm.enterPassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.pressSubmitButton();
        Assert.assertNotNull(driver.manage().getCookieNamed("accessToken"));
        Assert.assertTrue(driver.getCurrentUrl().contains(URL.PROFILE_PAGE));
        LOGGER.info("submit...");
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
        isCleanUpRequired = false;
    }

    @Test(testName = "Failed validation of authorization data")
    public void submitFormLogIn_shouldFailLogInValidation_whenPasswordIsInvalid() {
        driver.get(URL.LOG_IN_PAGE);
        PageLogIn webForm = new PageLogIn(driver);
        webForm.enterLogin();
        webForm.enterInvalidPassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.pressSubmitButton();

        Assert.assertNull(driver.manage().getCookieNamed("accessToken"));
        Assert.assertEquals(driver.getCurrentUrl(), URL.LOG_IN_PAGE);
        isCleanUpRequired = false;
    }

    @Test(testName = "Failed validation of authorization data")
    public void submitFormLogIn_shouldFailLogInValidation_whenPasswordIsEmpty() {
        driver.get(URL.LOG_IN_PAGE);
        PageLogIn webForm = new PageLogIn(driver);
        webForm.enterLogin();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.pressSubmitButton();

        Assert.assertNull(driver.manage().getCookieNamed("accessToken"));
        Assert.assertEquals(driver.getCurrentUrl(), URL.LOG_IN_PAGE);
        isCleanUpRequired = false;
    }

    @Test(testName = "Show password checkbox")
    public void showPassword_shouldShow() {
        driver.get(URL.LOG_IN_PAGE);
        PageLogIn webForm = new PageLogIn(driver);
        webForm.enterLogin();
        webForm.enterPassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.clickShowPasswordCheck();

        Assert.assertEquals(webForm.getPasswordInputType(), "text");
        isCleanUpRequired = false;
    }

    //TODO: FAILED
    @Test(testName = "Quit")
    public void quit_shouldQuit() {
        authorize();
        PageUser webForm = new PageUser(driver);
        webForm.dropdownUserLink.click();
        webForm.quit.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertNull(driver.manage().getCookieNamed("accessToken"));
        Assert.assertEquals(driver.getCurrentUrl(), URL.HOME_PAGE);

        isCleanUpRequired = false;
    }
    
    @Test(testName = "ChangeUserFirstAndLastName")
    @SneakyThrows
    public void changeUserFirstLastName_shouldChange() {
        authorize();
        PageUser webForm = new PageUser(driver);
        webForm.dropdownUserLink.click();
        webForm.settings.click();

        PageSetting pageSetting = new PageSetting(driver);
        String newFirstName = "newFirstName";
        String newLastName = "newLastName";
        pageSetting.firstNameInput.clear();
        pageSetting.firstNameInput.sendKeys(newFirstName);
        pageSetting.lastNameInput.clear();
        pageSetting.lastNameInput.sendKeys(newLastName);
        pageSetting.btnSubmitButton.click();

        String expectedFullName = newFirstName + " " + newLastName;
        try {
            WebElement webElement = driver.findElement(new By.ByXPath("//div[text()='" + expectedFullName + "']"));
            Assert.assertEquals(webElement.getText(), expectedFullName);
        } catch (Throwable anyException) {
            anyException.printStackTrace();
            Assert.fail("Full name is not changed as expected.");
        }
    }

    @Test(testName = "FailToChangeUserFirstName")
    @SneakyThrows
    public void changeUserFirstName_shouldNotChange_whenFirstNameContainsNumbers() {
        authorize();
        PageUser webForm = new PageUser(driver);
        webForm.dropdownUserLink.click();
        webForm.settings.click();

        PageSetting pageSetting = new PageSetting(driver);
        String newFirstName = "123456";
        pageSetting.firstNameInput.clear();
        pageSetting.firstNameInput.sendKeys(newFirstName);
        pageSetting.btnSubmitButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), URL.CHANGE_GENERAL_INFO_COMMAND);
        checkOnErrorMessageExist();
    }

    //TODO: FAILED
    @Test(testName = "FailToChangeUserFirstName")
    public void changeUserFirstName_shouldNotChange_whenFirstNameContainsHtmlInjection() {
        authorize();
        PageUser webForm = new PageUser(driver);
        webForm.dropdownUserLink.click();
        webForm.settings.click();

        PageSetting pageSetting = new PageSetting(driver);
        String newFirstName = "<h1>Injection</h1>";
        pageSetting.firstNameInput.clear();
        pageSetting.firstNameInput.sendKeys(newFirstName);
        pageSetting.btnSubmitButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), URL.CHANGE_GENERAL_INFO_COMMAND);
        checkOnErrorMessageExist();
    }
    
    @Test(testName = "ChangeUserPhoneNumber")
    public void changeUserPhoneNumber_shouldChange() {
        authorize();
        PageUser webForm = new PageUser(driver);
        webForm.dropdownUserLink.click();
        webForm.settings.click();

        PageSetting pageSetting = new PageSetting(driver);
        String newPhoneNumber = "375445547991";
        pageSetting.phoneNumberInput.clear();
        pageSetting.phoneNumberInput.sendKeys(newPhoneNumber);
        pageSetting.btnSubmitButton.click();
        try {
            WebElement webElement = driver.findElement(new By.ByXPath("//div[text()='" + newPhoneNumber + "']"));
            Assert.assertEquals(webElement.getText(), newPhoneNumber);
        } catch (Throwable anyException) {
            anyException.printStackTrace();
            Assert.fail("Phone number is not changed as expected.");
        }
    }

    @Test(testName = "ChangeUserBio")
    public void changeUserBio_shouldChange() {
        authorize();
        PageUser webForm = new PageUser(driver);
        webForm.dropdownUserLink.click();
        webForm.settings.click();

        PageSetting pageSetting = new PageSetting(driver);
        String newBio = "some bio funny";
        pageSetting.bioTextarea.clear();
        pageSetting.bioTextarea.sendKeys(newBio);
        pageSetting.btnSubmitButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            WebElement webElement = driver.findElement(new By.ByXPath("//div[text()='" + newBio + "']"));
            Assert.assertEquals(webElement.getText(), newBio);
        } catch (Throwable anyException) {
            anyException.printStackTrace();
            Assert.fail("Phone number is not changed as expected.");
        }
    }
    
    @SneakyThrows
    @Test(testName = "ChangeBalanceWithEmptyBalance")
    public void changeBalance_shouldNotChange_WhenBalanceIsEmpty() {
        authorize();
        driver.get(URL.ADMIN_PANEL_PAGE);
        WebElement balanceInput = driver.findElement(new By.ByCssSelector("input[type='number']"));
        balanceInput.clear();
        balanceInput.sendKeys("");
        var button = driver.findElement(new By.ByXPath("//button[contains(@Class,'btn-action-save-balance')]"));
        button.click();
        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            Assert.assertEquals(button.getText(), "Error");
        } catch (Throwable anyException) {
            anyException.printStackTrace();
            Assert.fail("No error message.");
        }
    }

    @SneakyThrows
    @Test(testName = "ChangeBalanceWithNegativeBalance")
    public void changeBalance_shouldChange_WhenBalanceIsNegative() {
        authorize();
        driver.get(URL.ADMIN_PANEL_PAGE);
        WebElement balanceInput = driver.findElement(new By.ByCssSelector("input[type='number']"));
        balanceInput.clear();
        balanceInput.sendKeys("-600");
        TimeUnit.SECONDS.sleep(1);
        var button = driver.findElement(new By.ByXPath("//button[contains(@Class,'btn-action-save-balance')]"));
        button.click();
        TimeUnit.SECONDS.sleep(1);
        try {
            Assert.assertEquals(button.getText(), "Error");
        } catch (Throwable anyException) {
            anyException.printStackTrace();
            Assert.fail("No error message.");
        }
    }

    @Test(testName = "Localization")
    @SneakyThrows
    public void changeLocale_shouldChangeSiteLocale() {
        driver.get(URL.SIGN_UP_PAGE);
        PageRegister webForm = new PageRegister(driver);
        webForm.btnEnLocal.click(); // Click EN locale
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String enLocaleHomeText = webForm.navlinkLink.getText();
        webForm.btnRuLocal.click(); // Click RU locale
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String ruLocaleHomeText = webForm.navlinkLink.getText();
        Assert.assertEquals(ruLocaleHomeText, "Главная");
        Assert.assertEquals(enLocaleHomeText, "Home");
        webForm.btnEnLocal.click(); // Click EN locale
        Thread.sleep(500);
        isCleanUpRequired = false;
    }

    @AfterMethod
    public void cleanUp() {
        LOGGER.info("1");
        if (!isCleanUpRequired) {
            return;
        }
        LOGGER.info("1/1");
        PageUser webForm = new PageUser(driver);
        webForm.dropdownUserLink.click();
        webForm.quit.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LOGGER.info("2");
    }

    private void authorize() {
        driver.get(URL.LOG_IN_PAGE);
        PageLogIn webForm = new PageLogIn(driver);
        webForm.enterLogin();
        webForm.enterPassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.pressSubmitButton();
    }

    private void checkOnErrorMessageExist() {
        try {
            driver.findElement(new By.ByXPath("//h3[contains(@class, 'error-message')]"));
            Assert.assertTrue(true, "Error message exist");
        } catch (Throwable anyException) {
            anyException.printStackTrace();
            Assert.fail("Full name is not changed as expected.");
        }
    }
}