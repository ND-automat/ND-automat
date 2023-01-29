import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {
    @FindBy(how = How.CSS, using = "div[data-asin^=B]\n")
    List<WebElement> itemsInCart;
    @FindBy(how = How.CSS, using = "#sc-subtotal-amount-activecart > span")
    WebElement shoppingCartSubtotal;



    By deleteItemButton = By.cssSelector("input[value=Delete]");
    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String getItemPriceByIndex(int index){
        return itemsInCart.get(index).getAttribute("data-price");
    }

    public void removeItemByIndex(int index){
        itemsInCart.get(index).findElement(deleteItemButton).click();
    }

    public String getShoppingCartTotal() {
        return shoppingCartSubtotal.getText().replace("$","");
    }
}
