package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JUnitProjectPage extends BasePage {

	WebDriver driver;

	public JUnitProjectPage(WebDriver driver) {
		driver = this.driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='data']") WebElement ADD_ITEM_INPUT_BOX;
	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @value='Add']") WebElement ADD_NEW_ITEM_ADD_BUTTON;
	@FindBy(how = How.XPATH, using = "//input[@name='allbox']") WebElement TOGGLE_ALL_CHECKBOX;
	@FindBy(how = How.XPATH, using = "//input[@name='todo[0]']") WebElement VALIDATE_ITEM_CHECK_BOX_ON_LIST;
	@FindBy(how = How.XPATH, using = "//input[@name='allbox']")	WebElement UNCHECK_TOGGLE_ALL_CHECKBOX;
	@FindBy(how = How.XPATH, using = "//input[@name='todo[0]']") WebElement FIRST_ITEM_ON_THE_LIST;
	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @value='Remove']")	WebElement REMOVE_BUTTON;

	public void insertNewItemName(String itemName) {
		ADD_ITEM_INPUT_BOX.sendKeys(itemName+generateRandomNum(99));
	}

	public void clickOnAddButtonToInsertNewItemName() {
		ADD_NEW_ITEM_ADD_BUTTON.click();
	}

	public void checkTheToggleAllCheckBox() {
		TOGGLE_ALL_CHECKBOX.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfListItemCheckBoxIsAlsoChecked(boolean isSelected) {
		if (isSelected == true) {
			validateCheckBoxChecked(VALIDATE_ITEM_CHECK_BOX_ON_LIST, isSelected);
		} else {
			System.out.println("The CheckBox is not checked!");
		}
	}

	public void unCheckTheToggleAllCheckBox() {
		UNCHECK_TOGGLE_ALL_CHECKBOX.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnFirstItemInTheListToSelect() {
		FIRST_ITEM_ON_THE_LIST.click();
	}

	public void clickOnRemoveButton() {
		REMOVE_BUTTON.click();
	}
	
	public void validateAllItemAreDeleted1() {
		String bodytext = driver.findElement(By.xpath("//body/div[2]/form/ul")).getText();
		
		if (bodytext.isEmpty()) {
			System.out.println("All items are deleted.");
		} else {
			System.out.println("All items are not deleted.");
		}   
	}	    
}
