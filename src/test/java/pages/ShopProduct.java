package pages;

import Setup.Setup;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopProduct extends Setup {
    WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),\"Shop\")]")
    WebElement btnShop;
    @FindBy(css = "img")
    List<WebElement> imgProduct;
    @FindBy(name = "product_cat")
    WebElement btnDropDown;
    @FindBy(className = "fa-search")
    WebElement searchBtn;
    @FindBy(name ="orderby")
    WebElement btnDropDownShort;
    @FindBy(name ="attribute_pa_color")
    WebElement btnDropDownChoose;
    @FindBy(className = "page-title")
    WebElement btnShopText;
    @FindBy(className = "woocommerce-loop-product__title")
    List <WebElement> sortByPopularityText;
    @FindBy(name ="s")
    WebElement btnSearchProduct;
    @FindBy(xpath = "//h1[contains(text(),'Black pants')]")
    WebElement BlackPant;
    @FindBy(className = "woocommerce-info")
    WebElement NotFoundText;
    @FindBy(className = "select2-search__field")
    WebElement ColorboxSearch;
    @FindBy(xpath = "//li[@class='select2-results__option select2-results__message']")
    WebElement NotFoundColorText;
    @FindBy(xpath = "//li[contains(text(),'White')]")
    WebElement whiteColor;
    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    WebElement btnApply;
    @FindBy(xpath = "//h2[contains(text(),'Black pants')]")
    WebElement BlackPantText;
    public ShopProduct(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void doClickShopTab() throws InterruptedException {
        btnShop.click();
        String shop=btnShopText.getText();
        Assert.assertEquals(shop,"Shop");
    }




    public void ShopProductSortPopularity() throws InterruptedException {
        Select select =new Select(btnDropDownShort);
        select.selectByIndex(1);
        Thread.sleep(2000);
        imgProduct.get(0).click();
        Thread.sleep(2000);
        String text1=driver.getCurrentUrl();
        System.out.println(text1);
        Assert.assertEquals(text1,"https://envothemes.com/envo-ecommerce/product/womens-dress/");


    }
    public void ShopSearchProduct() throws InterruptedException {


        Select select =new Select(btnDropDown);
        select.selectByIndex(3);
        Thread.sleep(2000);
        searchBtn.click();
        Thread.sleep(2000);
    }

    public void ShopProductSearch() throws InterruptedException {

        btnSearchProduct.sendKeys("Black pants");
        Thread.sleep(2000);
        searchBtn.click();
        Thread.sleep(2000);
        String p = BlackPant.getText();
        Assert.assertEquals(p,"Black pants");
    }
    public void ValidColor() throws InterruptedException {
        btnShop.click();
        Thread.sleep(2000);
        ColorboxSearch.click();
        Thread.sleep(2000);
        whiteColor.click();
        Thread.sleep(2000);
        btnApply.click();
        Thread.sleep(2000);
        String msg = BlackPantText.getText();
        System.out.println(msg);
        Assert.assertEquals(msg,"Black pants");
    }

    public void SearchNotAvailableProduct() throws InterruptedException {

        btnSearchProduct.sendKeys("bag");
        Thread.sleep(2000);
        searchBtn.click();
        Thread.sleep(2000);
        String NotFound = NotFoundText.getText();
        Assert.assertEquals(NotFound,"No products were found matching your selection.");
    }

    public void NotValidColor() throws InterruptedException {
        btnShop.click();
        ColorboxSearch.sendKeys("blue");
        String NotFoundColor = NotFoundColorText.getText();
        Assert.assertEquals(NotFoundColor,"No matches found");
    }



}
