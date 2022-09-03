package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/test/101/");
		return driver;
	}
		
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	/***Method to take screen shot***/
	public static void takeScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		// to format the file name of our screenshots
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
				
		try {
			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir")+"/screenshot/"+label+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
