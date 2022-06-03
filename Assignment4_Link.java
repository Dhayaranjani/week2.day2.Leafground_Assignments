package week2.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_Link {
//Play with HyperLinks
//--------------------
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Load the URL "http://leafground.com/pages/Link.html"
		driver.get("http://leafground.com/pages/Link.html");
		//Maximize the screen
		driver.manage().window().maximize();
		//Add Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1. Go to Home Page without clicking
		driver.findElement(By.linkText("Go to Home Page")).click();
		String pageTitle = "TestLeaf - Selenium Playground";		
		
		Thread.sleep(5000);
		
		//Verify the title		
		if(driver.getTitle().contains(pageTitle)) {
			System.out.println("Home page is Verified and the title is : " + pageTitle);
		}else
		{
			System.out.println("Home Page is not Verified");
		}
		
		driver.navigate().back();
		
		//2. Find where am supposed to go without clicking me? //Can use PartialLinkText too
		String toLink = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println("I am supposed to go to: " + toLink);
		Thread.sleep(5000);
		
		//3. Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title2 = driver.getTitle();
		
		Thread.sleep(5000);
		
		driver.navigate().back();
		//Verify the title
		String pageTitle2 = "404 Not Found";
		if(title2.equals(pageTitle2)){
			System.out.println("The link is broken");
		}else
			System.out.println("The link is not broken");
		
		//4. Go to Home Page (Interact with same link name)
		String goHomePageLink1 = driver.findElement(By.xpath("//a[text()='Go to Home Page']")).getAttribute("href");
		String goHomePageLink2 = driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).getAttribute("href");
		
		if(goHomePageLink1.equals(goHomePageLink2)){
			driver.navigate().to(goHomePageLink1);
			System.out.println("Go to Home Page: - Both are same link and clicked the first Link");
		}else {		
			System.out.println("Go to Home Page: - Both the links are not same");
		}
		
		Thread.sleep(5000);
		driver.navigate().back();
		
		//5. How many links are available in this page?
		 List<WebElement> findElements = driver.findElements(By.tagName("a"));
		 int size = findElements.size();
		 System.out.println("No of Links :" + size);
		 
		//driver.close();
	}

}
