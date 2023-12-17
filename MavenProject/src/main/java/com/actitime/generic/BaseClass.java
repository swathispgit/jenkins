package com.actitime.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/login.do");	Reporter.log("openBrowser",true);
	}	@AfterClass
	public void closeBrowser() {
		driver.quit();
		Reporter.log("closeBrowser",true);
	}	@BeforeMethod
	public void login()  {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();	Reporter.log("login",true);
	}@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click(); Reporter.log("logout",true);
	}
}
