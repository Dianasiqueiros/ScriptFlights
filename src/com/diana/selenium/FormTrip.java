package com.diana.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTrip {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "//Users//DSV//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");

		// calendar
		// driver.findElement(By.id("DepartDate")).click();
		// driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

		Select adultsSection = new Select(driver.findElement(By.id("Adults")));
		adultsSection.selectByValue("2");
		Select childrenSection = new Select(driver.findElement(By.id("Childrens")));
		childrenSection.selectByValue("2");
		Select infantsSection = new Select(driver.findElement(By.id("Infants")));
		infantsSection.selectByValue("1");

		driver.findElement(By.linkText("More options: Class of travel, Airline preference")).click();

		Select travelClassSection = new Select(driver.findElement(By.id("Class")));
		travelClassSection.selectByIndex(1);

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Diana");
		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
	}

}
