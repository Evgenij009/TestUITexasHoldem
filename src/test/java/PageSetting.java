import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PageSetting extends PageObject{

    @FindBy(name = "firstName")
    public WebElement firstNameInput;

    @FindBy(name = "lastName")
    public WebElement lastNameInput;

    @FindBy(name = "bio")
    public WebElement bioTextarea;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumberInput;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumberInput2;

    @FindBy(id = "btnSubmit")
    public WebElement btnSubmitButton;

    @FindBy(css = "a[onclick='changeBtnSubmitPas()']")
    public WebElement listgroupitemLink;

    @FindBy(id = "dropdownUser1")
    public WebElement dropdownUserLink;

    @FindBy(xpath = "//a[@href='/poker?command=profile-page&id=6']")
    public WebElement profileLink;

    public PageSetting(WebDriver driver) {
        super(driver);
    }
}
