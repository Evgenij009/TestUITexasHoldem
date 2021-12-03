import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PageLogIn extends PageObject{

    private static final String LOGIN = "vanya.semenovich";
    private static final String INCORRECT_LOGIN = "someincorrect.login";
    private static final String PASSWORD = "12345678";
    private static final String INCORRECT_PASSWORD = "123incorrect123";
    private static final String INVALID_PASSWORD = "small";

    @FindBy(name = "login")
    WebElement login;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "Log in")
    WebElement submit_button;

    @FindBy(css = "input[type='checkbox']")
    WebElement showPasswordCheckbox;

    public PageLogIn(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(){
        this.login.sendKeys(LOGIN);
    }

    public void enterPassword() {
        this.password.sendKeys(PASSWORD);
    }

    public void enterIncorrectPassword() {
        this.password.sendKeys(INCORRECT_PASSWORD);
    }

    public void enterInvalidPassword() {
        this.password.sendKeys(INVALID_PASSWORD);
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void clickShowPasswordCheck() {
        this.showPasswordCheckbox.click();
    }

    public String getPasswordInputType() {
        return password.getAttribute("type");
    }
}