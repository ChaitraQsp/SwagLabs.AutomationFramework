package productTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass{
	
    @Test(groups = "SmokeSuite")
    public void tc_001_AddProductToCartTest() throws IOException
	{
		
		//Read the Required Data	
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);
		
		//Navigate To Product and click on it
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnProduct(driver, PRODUCTNAME);
		
		//Add product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		//Navigate to Cart
		ip.clickOnCartContainer();
		
		//Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();
		
		Assert.assertEquals(productInCart, productAdded);
		
		Assert.assertTrue(productInCart.equals(productAdded));
		System.out.println(productInCart);
			
		
	}
    
    @Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
    public void sampleTest()
    {
    	Assert.fail();
    	System.out.println("sample");
    }

    
}
