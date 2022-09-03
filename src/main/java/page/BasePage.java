package page;

import java.util.Random;

import org.openqa.selenium.WebElement;

public class BasePage {

	/*** Method to validate check box is checked ***/
	public void validateCheckBoxChecked(WebElement element, boolean isSelected) {
		isSelected = element.isSelected();
	}

	/*** Method to generate a random number ***/
	public int generateRandomNum(int bound) {
		Random rand = new Random();
		int generatedNum = rand.nextInt(bound);
		return generatedNum;
	}

}
