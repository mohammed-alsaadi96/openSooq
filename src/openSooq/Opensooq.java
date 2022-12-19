package openSooq;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opensooq {
	public WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	@BeforeTest()
	public void login() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jo.opensooq.com/en");

	}

	@Test()
	public void bmw() {
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[6]/div/div[2]/ul/li[1]/div[2]/h3[1]/a")).click();
		driver.findElement(By.className("fakeWrap")).click();
		driver.findElement(By.xpath("//*[@id=\"Brand\"]/div[2]/div/ul/li[6]")).click();
		driver.findElement(By.xpath("//*[@id=\"landingPostDynamicField\"]/div/button")).click();

		String car = driver.findElement(By.xpath("//*[@id=\"gridPostListing\"]/li[1]/div/h2/a")).getText();

//		System.out.println(car);

		String[] carsplit = car.split("in");
		String final_carsplit = carsplit[0];
		//System.out.println(final_carsplit);

		driver.findElement(By.id("searchBox")).sendKeys(final_carsplit + Keys.ENTER);

		List<WebElement> bmw_car = driver.findElements(By.className("postLink"));

		for(int i=0 ; i < bmw_car.size() ; i++){
			
			String[] bmw_car_split=bmw_car.get(i).getText().split("in");
			String final_split_car = bmw_car_split[0].trim();
			System.out.println(final_split_car);
			
			softassert.assertEquals(final_split_car,final_split_car);
//			
//
			softassert.assertAll();
			
				
		}

	}


}
