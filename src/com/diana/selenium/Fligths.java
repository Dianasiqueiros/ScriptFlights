package com.diana.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Fligths {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//Users//DSV//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		// disable or enablen a opticion
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// System.out.println(driver.findElement(By.id("Div1")).isEnabled()); rsultado
		// true
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {

			System.out.println("its enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		// dinamic dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// from //a[@value='GUA']
		driver.findElement(By.xpath("//a[@value='GAU']")).click();
		// to //a[@value='GOP']
		driver.findElement(By.xpath("(//a[@value='GOP'])[2]")).click();// usando index
		// driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='GOP']")).click();//usando
		// parent to child

		// menu
		driver.findElement(By.id("divpaxinfo")).click();
		// select 5 adults
		//int i=1;while(i<5){driver.findElement(By.id("hrefIncAdt")).click();i++;} 
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		driver.findElement(By.id("btnclosepaxoption")).click();

		// automate a dropdown static
		Select dropdownStatic = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		dropdownStatic.selectByValue("AED");
		dropdownStatic.selectByVisibleText("USD");// dropdownStatic.selectByIndex(3);

		// checkbox
		// driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).click();

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();// checkbox regular expresion
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		// count the number for all the checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}
}
