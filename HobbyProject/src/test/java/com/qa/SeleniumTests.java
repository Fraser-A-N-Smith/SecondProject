package com.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumTests {
	
	private WebDriver driver;

	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		System.out.println(driver);
	}
	@Test
	void printTitle() {
		driver.get("http://127.0.0.1:5500/index.html");
		WebElement header = driver.findElement(By.xpath("/html/body/div/div/header/div[3]/div/div/div/div/div"));
		System.out.println(header.getText());
		Assertions.assertEquals("Welcome to the Cloak N' Stagger", this.driver.getTitle());
		
	}
	@Test
	void assertText() {
		driver.get("http://127.0.0.1:5500/index.html");
		WebElement header = driver.findElement(By.xpath("//*[@id=\"data entry\"]/div[1]"));
		//System.out.println(header.getText());
		Assertions.assertEquals("Party Name", header.getText());}
	
	@Test
	void navigateMenu() {
		driver.get("http://127.0.0.1:5500/index.html");
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/li[2]/a"));
		Assertions.assertEquals("Pricing & Menu", menu.getText());
	}
	@Test
	void goToMenu() {
		driver.get("http://127.0.0.1:5500/index.html");
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/li[2]/a"));
		menu.click();
		String testUrl = "http://127.0.0.1:5500/Menu.html";
		Assertions.assertEquals(testUrl, this.driver.getCurrentUrl());

		
	
}}
