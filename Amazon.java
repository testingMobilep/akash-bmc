package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Amazon");
		Thread.sleep(4000);
		List<WebElement> allSuggestions = driver.findElements(
				By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul"));
		for (WebElement suggestion : allSuggestions) {
			System.out.println(suggestion.getText());
			search.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//h3[text()='Amazon.in']")).click();

			Select se = new Select(driver.findElement(By.id("searchDropdownBox")));
			se.selectByValue("search-alias=electronics");

			WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
			ele.sendKeys("DellComputers");
			ele.sendKeys(Keys.ENTER);

			driver.findElement(By.id("low-price")).sendKeys("30000");

			driver.findElement(By.id("high-price")).sendKeys("50000");
			driver.findElement(By.xpath("//*[@id=\"a-autoid-1\"]/span/input")).click();

			driver.findElement(By.xpath(
					"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[10]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
					.click();
			driver.navigate().back();
			List<WebElement> ratings = driver.findElements(By.xpath("//span[@class='a-size-base']"));
			for (WebElement ProductRatings : ratings) {
				System.out.println(ProductRatings.getText());}
				
			if (ratings.contains("5.0")) {
			
					System.out.println("product with 5 out of 5 rating found");
				} else {
					System.out.println("product with 5 out of 5 rating not found");
				}
			

		}
	}
}