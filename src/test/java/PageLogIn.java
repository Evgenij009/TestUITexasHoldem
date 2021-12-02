import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLogIn extends PageObject{

    private static final String LOGIN = "vanya.semenovich";
    private static final String PASSWORD = "12345678";

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "Log in")
    private WebElement submit_button;

    public PageLogIn(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(){
        this.login.sendKeys(LOGIN);
    }

    public void enterPassword(){
        this.password.sendKeys(PASSWORD);
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }
}