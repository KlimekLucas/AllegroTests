package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfFoundItems {

    @FindBy(id = "price_to")
    private WebElement maxPrice;

    public ListOfFoundItems(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setMaxPrice(int maxPriceValue){
        maxPrice.click();
        maxPrice.clear();
        maxPrice.sendKeys(String.valueOf(maxPriceValue));
        maxPrice.submit();
    }
}
