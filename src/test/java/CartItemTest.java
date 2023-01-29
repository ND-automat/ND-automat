import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

public class CartItemTest extends BaseTest {
    @DisplayName("Search for items, add and remove them")
    @CsvFileSource(files = "src/test/resources/CartItemTestProperties.csv", numLinesToSkip = 1)
    @ParameterizedTest
    public void AddRemoveItemCartTest(String homepageURL, String searchTerm) {
        HomePage homePage = new HomePage(driver, homepageURL);
        homePage.setSearchText(searchTerm);
        homePage.submitSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.sortResultsByAvg();

        int[] itemIndices = {2, 3};

        List<String> itemUrls = new ArrayList<>();

        for (int item : itemIndices
        ) {
            itemUrls.add(searchResultsPage.getItemLinkFromResults(item));
        }

        ProductPage productPage = null;
        for (String itemUrl : itemUrls
        ) {
            productPage = new ProductPage(driver, itemUrl);
            productPage.addProductToCart();
            ItemConfirmationPage itemConfirmationPage = new ItemConfirmationPage(driver);
            Assertions.assertTrue(itemConfirmationPage.isItemAddedToCart());
        }
        productPage.navigateToCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        String remainingItemPrice = shoppingCartPage.getItemPriceByIndex(0);
        shoppingCartPage.removeItemByIndex(1);
        Assertions.assertEquals(remainingItemPrice, shoppingCartPage.getShoppingCartTotal());
    }
}