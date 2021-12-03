import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://13.49.159.31:1234///poker?command=sign-up-page
public class PageRegister {

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement navlinkLink;

    @FindBy(xpath = "//a[text()='Play']")
    public WebElement navlinkPlay;

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement btnLinkLogIn;

    @FindBy(css = ".btn-warning")
    public WebElement btnLink2;

    @FindBy(xpath = "//a[text()='RU']")
    public WebElement btnRuLocal;

    @FindBy(xpath = "//a[text()='EN']")
    public WebElement btnEnLocal;

    @FindBy(id = "loginRegForm")
    public WebElement loginInput;

    @FindBy(css = ".login-error")
    public WebElement loginerrorSpan;

    @FindBy(id = "currentPass")
    public WebElement passwordInput;

    @FindBy(css = "input[type='checkbox']")
    public WebElement elementInput;

    @FindBy(xpath = "//span[text()='Repeat password']")
    public WebElement formlabelSpan;

    @FindBy(xpath = "//input[not(@id='currentPass') and contains(@class, 'password')]")
    public WebElement passwordRepeatInput;

    @FindBy(css = ".password-error")
    public WebElement passworderrorSpan;

    @FindBy(name = "firstName")
    public WebElement firstNameInput;

    @FindBy(name = "lastName")
    public WebElement lastNameInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(css = ".email-error")
    public WebElement emailerrorSpan;

    @FindBy(name = "phoneNumber")
    public WebElement phoneInput;

    @FindBy(css = "h3")
    public WebElement msgDanger;

    @FindBy(css = "button")
    public WebElement btnRegister;

    public PageRegister(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}