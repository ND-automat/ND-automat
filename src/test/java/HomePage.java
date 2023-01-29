import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(how = How.CSS, using = "input[id=twotabsearchtextbox]")
    WebElement searchBox;

    @FindBy(how = How.CSS, using = "input[id=nav-search-submit-button]")
    WebElement searchSubmitButton;

    public HomePage(WebDriver driver, String URL) {
        driver.get(URL);
        PageFactory.initElements(driver,this);
    }

    public void submitSearch(){
        searchSubmitButton.click();
    }

    public void setSearchText(String searchText){
        searchBox.sendKeys(searchText);
    }

}
