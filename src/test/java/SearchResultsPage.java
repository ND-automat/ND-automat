import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;

    By resultsItemsInPage = By.cssSelector("span[data-component-type=\"s-search-results\"] div[data-asin^=B]");

    By elementWithURL = By.cssSelector("a[class$=s-no-outline]");

    @FindBy(how = How.CSS, using = "#s-result-sort-select")
     WebElement sortOptions;

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void sortResultsByAvg() {
        Select select = new Select(sortOptions);
        select.selectByValue("review-rank");
    }

    public String getItemLinkFromResults(int index) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfElementsToBeMoreThan(resultsItemsInPage,0));
        List<WebElement> results = driver.findElements(resultsItemsInPage);
        return results.get(index).findElement(elementWithURL).getAttribute("href");
    }
}
