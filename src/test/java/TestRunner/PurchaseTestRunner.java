package TestRunner;

import Setup.Setup;
import org.testng.annotations.Test;
import pages.purchaseProduct;


public class PurchaseTestRunner extends Setup {
    @Test(priority = 0 ,groups = "Purchase")
    public void doPurchaseTab() throws InterruptedException {
        purchaseProduct purchase = new purchaseProduct(driver);
        driver.get("https://envothemes.com/envo-ecommerce/");
        purchase.SelectProduct();
    }

    @Test(priority = 1,groups = "Purchase")
    public void AddToCart() throws InterruptedException {
        purchaseProduct purchase = new purchaseProduct(driver);
        purchase.ProductAddToCart();
    }
}
