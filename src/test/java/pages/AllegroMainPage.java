package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllegroMainPage {

    @FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div/div/div[2]/div[2]/button[1]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/header/div/div/div/div/form/input")
    private WebElement searchComboBox;

    public AllegroMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAcceptCookiesButton() {
        acceptCookiesButton.click();
    }

    public void searchForProduct(String product) {
        searchComboBox.sendKeys(product);
        searchComboBox.submit();
    }
}
