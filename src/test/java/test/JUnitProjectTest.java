package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.JUnitProjectPage;
import util.BrowserFactory;

public class JUnitProjectTest {

	WebDriver driver;
	JUnitProjectPage test1Page;

	@Before
	public void openUrl() {
		driver = BrowserFactory.init();
		test1Page = PageFactory.initElements(driver, JUnitProjectPage.class);
	}

	@Test
	public void validateToggleAllCheckBoxIsCheckedAndItemsRemoved() {
		test1Page.insertNewItemName("Pen");
		test1Page.clickOnAddButtonToInsertNewItemName();
		test1Page.insertNewItemName("Paper");
		test1Page.clickOnAddButtonToInsertNewItemName();
		test1Page.insertNewItemName("Pencil");
		test1Page.clickOnAddButtonToInsertNewItemName();
		test1Page.insertNewItemName("Notepad");
		test1Page.clickOnAddButtonToInsertNewItemName();
		test1Page.checkTheToggleAllCheckBox();

		test1Page.validateIfListItemCheckBoxIsAlsoChecked(true);

		removeOneItemFromTheList(); // Remove one item
		removeAllItemsFromTheList(); // Remove all items
	}

	/*** Test 2: Method to remove an item from the list ***/
	public void removeOneItemFromTheList() {

		test1Page.unCheckTheToggleAllCheckBox();
		test1Page.clickOnFirstItemInTheListToSelect();
		test1Page.clickOnRemoveButton();
	}

	/*** Test 3: Method to remove all items from the list, validate if all items are deleted and take Screenshot***/
	public void removeAllItemsFromTheList() {

		test1Page.checkTheToggleAllCheckBox();
		test1Page.clickOnRemoveButton();
		
		BrowserFactory.takeScreenshot(driver);

		String bodytext = driver.findElement(By.xpath("//body/div[2]/form/ul")).getText();
		if (bodytext.isEmpty()) {
			System.out.println("All items are deleted.");
		} else {
			System.out.println("All items are not deleted.");
		}
	}

	@After
	public void closeBrowser() {
		BrowserFactory.tearDown();
	}
}
