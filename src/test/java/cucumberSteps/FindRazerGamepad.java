package cucumberSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AllegroMainPage;
import pages.ListOfFoundItems;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class FindRazerGamepad {

    private WebDriver driver;
    private AllegroMainPage allegroMainPage;
    private ListOfFoundItems listOfFoundItems;


    @Given("^Open page: (.*)$")
    public void beforeEach(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get(url);
        allegroMainPage = new AllegroMainPage(driver);
        listOfFoundItems = new ListOfFoundItems(driver);

    }


    @When("AcceptCookies")
    public void acceptcookies() {
        allegroMainPage.clickAcceptCookiesButton();
    }

    @And("SearchForProduct (.*)$")
    public void searchforproduct(String wantedItem) {
        allegroMainPage.searchForProduct(wantedItem);
    }

    @And("SetMax Price {int}")
    public void setmaxPrice(int maxPrice) {
        listOfFoundItems.setMaxPrice(maxPrice);
    }

    @And("take Screenshot")
    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "screens", "registration-success-evidence-" + currentDateTime + ".png"));
    }
}
