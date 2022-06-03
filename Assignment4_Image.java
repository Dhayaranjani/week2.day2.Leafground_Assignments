package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_Image {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Load the URL "http://leafground.com/pages/Image.html"
		driver.get("http://leafground.com/pages/Image.html");
		//Maximize the screen
		driver.manage().window().maximize();
		//Add Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1. Click on the image to go home page
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div/div/img")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		//2. Am I Broken Image?
		WebElement EleImg = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/img"));
		//Get the src of the Page and print it
		String EleImgSrc = EleImg.getAttribute("src");
		System.out.println(EleImgSrc);
		
		//Navigate to the Broken page and get the title of the page
		driver.navigate().to(EleImgSrc);
		Thread.sleep(5000);
		String ImgpageTitle = driver.getTitle();
		String ImgPageErrTitle = "404 Not Found";
		
		//Compare the title has error then redirect accordingly
		if(ImgpageTitle.equals(ImgPageErrTitle)){
			System.out.println("The link is broken");
		}else
			System.out.println("The link is not broken");
		
		//Now navigate to home page
		driver.navigate().back();
		
		Thread.sleep(5000);
		
		//3. Click me using Keyboard or Mouse
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/img")).click();
		Thread.sleep(5000);
		driver.navigate().back();
	}

}
