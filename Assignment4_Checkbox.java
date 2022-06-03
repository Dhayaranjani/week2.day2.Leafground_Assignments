package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_Checkbox {
	//Interact with Checkboxes
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Load the URL "http://leafground.com/pages/checkbox.html"
		driver.get("http://leafground.com/pages/checkbox.html");
		//Maximize the screen
		driver.manage().window().maximize();
		//Add Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1. Select the languages that you know?
		driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/input[3]")).click();
		
		//2. Confirm/Verify Selenium is checked
		boolean selselected = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/input")).isSelected();
		if(selselected==true) {
			System.out.println("Verified that Selenium is Checked");
		}else
			System.out.println("Selenium is not Checked");
		Thread.sleep(5000);
		
		//3. DeSelect only checked
		//1stcheckbox check
		boolean deSelect1 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/input[1]")).isSelected();
		if(deSelect1==true) { 
			driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/input[1]")).click(); 
		} //2ndcheckbox check 
		boolean deSelect2 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/input[2]")).isSelected();
		if(deSelect2==true) { 
			driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/input[2]")).click(); 
		}
		 
		//4. Select all below checkboxes
		for(int i=1; i<=6; i++){
			driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/input[" + i + "]")).click();
		}
	}
}
