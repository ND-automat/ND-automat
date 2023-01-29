import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemConfirmationPage {
    private WebDriver driver;

    By itemAddedSuccess = By.cssSelector("#NATC_SMART_WAGON_CONF_MSG_SUCCESS");
    public ItemConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public boolean isItemAddedToCart() {
          return new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(itemAddedSuccess))).isDisplayed();
    }
}
