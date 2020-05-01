package com.diana.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//Users//DSV//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.com.mx/?&tag=hydramzkw0mx-20&ref=pd_sl_2z8sof6k6a_e&adgrpid=54571069141&hvpone=&hvptwo=&hvadid=286729176607&hvpos=&hvnetw=g&hvrand=4681902125768647300&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1010079&hvtargid=kwd-399476014013&hydadcr=322_1011713580&gclid=CjwKCAjwvtX0BRAFEiwAGWJyZIvVjHehZw97RPrfcSBT9aF3iy5dHnvnsWTPqczhv6LNyiRd44k23BoC2cgQAvD_BwE");
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// variable for the element, because the endpoint is the samen
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.clear();
		search.sendKeys("corti");
		

		search.sendKeys(Keys.ARROW_DOWN);

		search.sendKeys(Keys.ENTER);

	}

}
