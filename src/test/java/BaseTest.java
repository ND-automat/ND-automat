import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
public class BaseTest {
    public static RemoteWebDriver driver;

    @BeforeEach
     public void setup() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserVersion", "latest");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("options", caps);
        URL url = new URL("https://automation2345:768fe149-b094-43ca-96c7-f734b25247b1@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, options);
    }
    @AfterEach
    public void teardown(){
        driver.quit();
        BaseTest.driver = null;
    }
}