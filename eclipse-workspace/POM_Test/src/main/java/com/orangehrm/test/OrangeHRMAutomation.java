package com.orangehrm.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMAutomation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup(); 

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		try {
			// Open login page
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

			// Login
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			Thread.sleep(4000); // Wait for dashboard

			// Navigate to Apply Leave
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
			Thread.sleep(3000);

			// Select leave type
			driver.findElement(By.xpath("//div[@class='oxd-select-text--after']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Annual Leave']")).click();

			// Enter From Date
			WebElement fromDate = driver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]"));
			fromDate.sendKeys("2025-05-15");

			// Enter To Date
			WebElement toDate = driver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]"));
			toDate.sendKeys("2025-05-15");

			// Click Apply
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			Thread.sleep(3000);
			System.out.println("✅ Leave applied successfully!");

		} catch (Exception e) {
			System.out.println("❌ Error:: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
