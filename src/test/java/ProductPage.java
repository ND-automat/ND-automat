import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProductPage {

    private WebDriver driver;
    @FindBy(how = How.CSS, using = "input[id=add-to-cart-button]")
    WebElement addToCartButton;

    @FindBy(how = How.CSS, using = " a[id=nav-cart]")
    WebElement cartButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ProductPage(WebDriver driver, String url){
        driver.navigate().to(url);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void addProductToCart() {
        addToCartButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void navigateToCart(){
        cartButton.click();
    }
}
