package ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

class TestLoginSemPageObject {

	private static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = WebDriverManager.chromedriver().clearDriverCache().create();
	}
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@Test
	void loginWithStandardUser() {
		driver.get("https://www.saucedemo.com/");
		WebElement loginBotton = driver.findElement(By.cssSelector("input[data-test=\"login-button\"]"));
		WebElement inputUsername = driver.findElement(By.cssSelector("input[data-test=\"username\"]"));
        WebElement inputPassword = driver.findElement(By.cssSelector("input[data-test=\"password\"]"));
        
        inputUsername.sendKeys("standard_user");
        inputPassword.sendKeys("secret_sauce");
        loginBotton.submit();
        
        WebElement imageBackpack = driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Backpack\"]"));
        assertEquals("/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", imageBackpack.getDomAttribute("src"));

	}
	
	@Test
	void loginWithLockedOutUser() {
		driver.get("https://www.saucedemo.com/");
		WebElement loginBotton = driver.findElement(By.cssSelector("input[data-test=\"login-button\"]"));
		WebElement inputUsername = driver.findElement(By.cssSelector("input[data-test=\"username\"]"));
        WebElement inputPassword = driver.findElement(By.cssSelector("input[data-test=\"password\"]"));
        
        inputUsername.sendKeys("locked_out_user");
        inputPassword.sendKeys("secret_sauce");
        loginBotton.submit();
        
        WebElement boxErrorLocator = driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
        assertEquals("Epic sadface: Sorry, this user has been locked out.", boxErrorLocator.getText());

	}
	
	@Test
	void loginWithProblemUser() {
		
		driver.get("https://www.saucedemo.com/");
		WebElement loginBotton = driver.findElement(By.cssSelector("input[data-test=\"login-button\"]"));
		WebElement inputUsername = driver.findElement(By.cssSelector("input[data-test=\"username\"]"));
        WebElement inputPassword = driver.findElement(By.cssSelector("input[data-test=\"password\"]"));
        
        inputUsername.sendKeys("problem_user");
        inputPassword.sendKeys("secret_sauce");
        loginBotton.submit();
		
        WebElement imageBackpack = driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Backpack\"]"));
        WebElement imageBolt = driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Bolt T-Shirt\"]"));
        WebElement imageOnesie = driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Onesie\"]"));
        WebElement imageBike = driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Bike Light\"]"));
        WebElement imageFleece = driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Fleece Jacket\"]"));
        WebElement imageTShirt = driver.findElement(By.cssSelector("img[alt=\"Test.allTheThings() T-Shirt (Red)\"]"));
        
        assertEquals("/static/media/sl-404.168b1cce.jpg", imageBackpack.getDomAttribute("src"));
        assertEquals("/static/media/sl-404.168b1cce.jpg", imageBolt.getDomAttribute("src"));
        assertEquals("/static/media/sl-404.168b1cce.jpg", imageOnesie.getDomAttribute("src"));
        assertEquals("/static/media/sl-404.168b1cce.jpg", imageBike.getDomAttribute("src"));
        assertEquals("/static/media/sl-404.168b1cce.jpg", imageFleece.getDomAttribute("src"));
        assertEquals("/static/media/sl-404.168b1cce.jpg", imageTShirt.getDomAttribute("src"));
	}
	
	@Test
	void loginWithPerformanceGlitchUser() {
		driver.get("https://www.saucedemo.com/");
		WebElement loginBotton = driver.findElement(By.cssSelector("input[data-test=\"login-button\"]"));
		WebElement inputUsername = driver.findElement(By.cssSelector("input[data-test=\"username\"]"));
        WebElement inputPassword = driver.findElement(By.cssSelector("input[data-test=\"password\"]"));
        
        inputUsername.sendKeys("performance_glitch_user");
        inputPassword.sendKeys("secret_sauce");
        loginBotton.submit();
        
        WebElement imageBackpack = driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Backpack\"]"));
        assertEquals("/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", imageBackpack.getDomAttribute("src"));
	}

}
