package TestRunner;

import Setup.Setup;
import org.testng.annotations.Test;
import pages.SaleProduct;

public class SaleTestRunner extends Setup {
    @Test(priority = 0)
    public void doClickSaleTab() throws InterruptedException {
        SaleProduct getText= new SaleProduct(driver);
        driver.get("https://envothemes.com/envo-ecommerce/");
        getText.doClickSaleTab();


    }
    @Test(priority = 1)
    public void GetCurrentUrL() throws InterruptedException {
        SaleProduct url= new SaleProduct(driver);
        url.GetUrl();


    }

    @Test(priority = 2)
    public void Tittle() throws InterruptedException {
        SaleProduct tittle= new SaleProduct(driver);
        tittle.GetTittle();


    } @Test(priority = 3)
    public void AddCartSaleInvalidCoupon() throws InterruptedException {
        SaleProduct  invalidCoupon= new SaleProduct(driver);
        invalidCoupon.AddCartSaleProductInvalidCoupon();

    }
    @Test(priority = 4)
    public void AddCartSaleCheckoutBlankPlaceOrder() throws InterruptedException {
        SaleProduct  invalidMsg= new SaleProduct(driver);
        invalidMsg.CheckoutBlankPlaceOrder();

    }



}
