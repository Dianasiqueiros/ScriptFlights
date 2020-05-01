package com.diana.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CorrectTextAlert {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "//Users//DSV//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String name = "Diana";
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		/*
		 * //alert with options driver.findElement(By.id("name")).sendKeys(name);
		 * driver.findElement(By.id("confirmbtn")).click();
		 * driver.switchTo().alert().dismiss();
		 * System.out.println(driver.switchTo().alert().getText());
		 * 
		 */
	}

}
