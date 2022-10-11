import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BSDemo {


    public static void main(String[] args) throws MalformedURLException {
//        setx BROWSERSTACK_USERNAME "mikeshchebec_6s1ZuY"
//        setx BROWSERSTACK_ACCESS_KEY "Azo4heERqqeUXpTFuKRy"
        String browserstackUsername = "mikeshchebec_6s1ZuY";
        String browserstackKey = "Azo4heERqqeUXpTFuKRy";

//        OR
//        setx BROWSERSTACK_USERNAME "mikeshchebec_6s1ZuY"
//        setx BROWSERSTACK_ACCESS_KEY "Azo4heERqqeUXpTFuKRy"
//        public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
//        public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
//        public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("browserstack.local", "true");
        browserOptions.setCapability("os", "Windows");
        browserOptions.setCapability("osVersion", "11");
        browserOptions.setCapability("browserstack.local", "true");

        browserOptions.setCapability("browserName", "Chrome");
        browserOptions.setCapability("browserVersion", "latest");

//        usual WebDriver just in case; remember to update path to chromedriver
//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new RemoteWebDriver(
                new URL("http://" + browserstackUsername + ":" + browserstackKey + "@" + "hub.browserstack.com" + "/wd/hub"), browserOptions);

        String baseUrl = "https://www.w3schools.com/python/";
        String expectedTitle = "Python Tutorial";

        driver.get(baseUrl);
        String actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        driver.close();
        driver.quit();
    }

}