package com.diana.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ScriptExample {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//Users//DSV//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// departure dinamic dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// from
		driver.findElement(By.xpath("//a[@value='IXB']")).click();
		// to
		driver.findElement(By.xpath("(//a[@value='JAI'])[2]")).click();
		// calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {

			System.out.println("its enabled");
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
		// static dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		for (int i = 1; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		driver.findElement(By.id("btnclosepaxoption")).click();
		// checkbox
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();// checkbox regular expresion
		// automate a dropdown static
		Select dropdownStatic = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		dropdownStatic.selectByValue("AED");

		// search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
}