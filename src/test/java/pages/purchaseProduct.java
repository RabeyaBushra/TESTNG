package pages;

import Setup.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class purchaseProduct extends Setup {

    WebDriver driver;
    @FindBy(name = "product_cat")
    WebElement btnDropDown;
    @FindBy(className = "fa-search")
    WebElement searchBtn;
    @FindBy(xpath = "//h2[contains(text(),'Modern')]")
    WebElement btnImg;
    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement btnAddCart;
    @FindBy(xpath = "//a[contains(text(),'View cart')]")
    List<WebElement> viewCart;
    @FindBy(xpath = "//a[contains(text(),\"Proceed to checkout\")]")
    WebElement btnCheckout;




    public purchaseProduct(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void SelectProduct() throws InterruptedException {
        Select select =new Select(btnDropDown);
        select.selectByIndex(3);
        Thread.sleep(2000);
        searchBtn.click();
        Thread.sleep(2000);
    }
    public void ProductAddToCart() throws InterruptedException {

        btnImg.click();
        Thread.sleep(2000);
        btnAddCart.click();
        Thread.sleep(5000);
        viewCart.get(2).click();
        Thread.sleep(2000);
        btnCheckout.click();
    }
}
