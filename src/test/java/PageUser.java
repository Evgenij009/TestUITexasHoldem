import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageUser extends PageObject {

    @FindBy(xpath = "//a[@href='/poker?command=logout']")
    public WebElement quit;

    @FindBy(xpath = "//a[@href='/poker?command=account-settings-page']")
    public WebElement settings;

    @FindBy(id = "dropdownUser1")
    public WebElement dropdownUserLink;


    public PageUser(WebDriver driver) {
        super(driver);
    }
}
