package TestRunner;

import Setup.Setup;
import org.testng.annotations.Test;

import pages.ShopProduct;


public class ShopProductTestRunner extends Setup {
    @Test(priority = 0)
    public void ShopSearchAllProduct() throws InterruptedException {
        ShopProduct searchText= new ShopProduct(driver);
        driver.get("https://envothemes.com/envo-ecommerce/");
        searchText.doClickShopTab();


    }
    @Test(priority = 1)
    public void ShopProductSortByPopularity() throws InterruptedException {
        ShopProduct sortPopularity= new ShopProduct(driver);
        sortPopularity.ShopProductSortPopularity();


    }



    @Test(priority = 2 )
    public void ShopSearchProducts() throws InterruptedException {
        ShopProduct search= new ShopProduct(driver);
        search.ShopSearchProduct();


    }

    @Test(priority = 3)
    public void ShopProductsProducts() throws InterruptedException {
        ShopProduct searchPant= new ShopProduct(driver);
        searchPant.ShopProductSearch();


    }
      @Test(priority = 4)
  public void AvailableColor() throws InterruptedException {
          ShopProduct validColor= new ShopProduct(driver);
          validColor.ValidColor();


  }
   @Test(priority = 5)
    public void NotAvailableProduct() throws InterruptedException {
       ShopProduct searchBag= new ShopProduct(driver);
        searchBag.SearchNotAvailableProduct();


    }

    @Test(priority = 6)
    public void NotAvailableColor() throws InterruptedException {
        ShopProduct invalidColor= new ShopProduct(driver);
        invalidColor.NotValidColor();


    }




}
