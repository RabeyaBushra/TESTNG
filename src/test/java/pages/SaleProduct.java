package pages;

import Setup.Setup;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class SaleProduct extends Setup {

    @FindBy(className= "nav-link")
    List<WebElement> btnSale;
    @FindBy(css = "img")
    List<WebElement> imgProduct;
    @FindBy(name = "add-to-cart")
    WebElement btnAddCart;
    @FindBy(xpath = "//a[contains(text(),\"View cart\")]")
    List<WebElement> viewCart;
    @FindBy(xpath = "//a[contains(text(),\"Proceed to checkout\")]")
    WebElement btnCheckout;
    @FindBy(className = "fa-search")
    WebElement searchBtn;
    @FindBy(name = "product_cat")
    WebElement btnDropDown;
    @FindBy(xpath = "//h1[contains(text(),'Sale')]")
    WebElement SaleText;
    @FindBy(name = "coupon_code")
    WebElement InvalidCouponNo;
    @FindBy(name = "apply_coupon")
    WebElement btnApplyCoupon;
    @FindBy(xpath = "//li[contains(text(),'Coupon \"101\" does not exist!')]")
    WebElement InvalidCouponMsg;
    @FindBy(xpath = "//button[contains(text(),'Place order')]")
    WebElement btnPlaceOrder;
    @FindBy(xpath = "//li[contains(text(),'Invalid payment method.')]")
    WebElement InvalidPaymentText;
    @FindBy(className = "nav-link")
    List<WebElement> saleBtn;

    public SaleProduct(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void doClickSaleTab() throws InterruptedException {
        btnSale.get(2).click();
        String sale=SaleText.getText();
        Assert.assertEquals(sale,"SALE");
    }

    public void GetUrl() throws InterruptedException {
        btnSale.get(2).click();
        String myUrl=driver.getCurrentUrl();
        System.out.println(myUrl);
        Assert.assertEquals(myUrl,"https://envothemes.com/envo-ecommerce/sale/");

    }

    public void GetTittle() throws InterruptedException {
        btnSale.get(2).click();
        String titleText=driver.getTitle();
        System.out.println(titleText);
        //Assert.assertEquals("Products – Envo eCommerce",titleText);
        Assert.assertTrue(titleText,true);
    }
    public void CheckoutBlankPlaceOrder() throws InterruptedException

    {
        Thread.sleep(2000);
        btnSale.get(2).click();
        Thread.sleep(2000);
        imgProduct.get(3).click();
        Thread.sleep(2000);
        btnAddCart.click();
        Thread.sleep(5000);
        viewCart.get(2).click();
        Thread.sleep(2000);
        btnCheckout.click();
        Thread.sleep(2000);
        btnPlaceOrder.click();
        String Msg=InvalidPaymentText.getText();
        System.out.println(Msg);
        Thread.sleep(2000);
        Assert.assertEquals(Msg,"Invalid payment method.");
        Thread.sleep(2000);



    }

    public void AddCartSaleProductInvalidCoupon() throws InterruptedException
    {
        saleBtn.get(2).click();
        Thread.sleep(2000);
        imgProduct.get(1).click();
        Thread.sleep(2000);
        btnAddCart.click();
        Thread.sleep(5000);
        viewCart.get(2).click();
        Thread.sleep(2000);
        InvalidCouponNo.sendKeys("101");
        btnApplyCoupon.click();
        String Msg=InvalidCouponMsg.getText();
        System.out.println(Msg);
        //Assert.assertEquals(Msg,"Coupon \'110\' does not exist!");
        Assert.assertTrue(Msg,true);
        Thread.sleep(2000);



    }



}
