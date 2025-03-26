package productTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class AddLowestPrizeProductTest extends BaseClass {

	@Test
	public void tc_002_addLowestPriceProductToCartTest() throws EncryptedDocumentException, IOException {

		// Read the Required Data
		String SORTOPTION = fUtil.readDataFromExcel("Products", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 4, 3);

		// Navigate To Product and click on it
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnSortedProduct(driver, PRODUCTNAME, SORTOPTION);

		// Add product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Navigate to Cart
		ip.clickOnCartContainer();

		// Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();

		Assert.assertEquals(productInCart, productAdded);

		Assert.assertTrue(productInCart.equals(productAdded));
		System.out.println(productInCart);
		
	}
}
