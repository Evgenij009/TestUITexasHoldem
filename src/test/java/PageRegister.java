import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://13.49.159.31:1234///poker?command=sign-up-page
public class PageRegister {

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement navlinkLink;

    @FindBy(xpath = "//a[text()='Play']")
    public WebElement navlinkLink2;

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement btnLink;

    @FindBy(css = ".btn-warning")
    public WebElement btnLink2;

    @FindBy(xpath = "//a[text()='RU']")
    public WebElement btnLink3;

    @FindBy(xpath = "//a[text()='EN']")
    public WebElement btnLink4;

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

    @FindBy(xpath = "//div[@class='mb-3'][.//span[text()='Repeat password']]//input")
    public WebElement formcontrolInput;

    @FindBy(css = ".password-error")
    public WebElement passworderrorSpan;

    @FindBy(xpath = "//span[text()='First name']")
    public WebElement formlabelSpan2;

    @FindBy(xpath = "//span[text()='Last name']")
    public WebElement formlabelSpan3;

    @FindBy(xpath = "//span[text()='Email']")
    public WebElement formlabelSpan4;

    @FindBy(css = ".email-error")
    public WebElement emailerrorSpan;

    @FindBy(xpath = "//span[text()='Phone number']")
    public WebElement formlabelSpan5;

    @FindBy(css = "h3")
    public WebElement textdangerH3;

    @FindBy(css = "button")
    public WebElement btnButton;

    public PageRegister(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}