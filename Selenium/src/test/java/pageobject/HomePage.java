package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	protected WebDriver driver;
	private final String url = "https://www.saucedemo.com/inventory.html";
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		
		if (!driver.getCurrentUrl().equals(url)) {
			throw new IllegalStateException("Esta não é a página principal");
		}
	}
	
	public WebElement imageBackpack() {
		return driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Backpack\"]"));
	}
	
	public WebElement imageBolt() {
		return driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Bolt T-Shirt\"]"));
	}
	
	public WebElement imageOnesie() {
		return driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Onesie\"]"));
	}
	
	public WebElement imageBike() {
		return driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Bike Light\"]"));
	}
	
	public WebElement imageFleece() {
		return driver.findElement(By.cssSelector("img[alt=\"Sauce Labs Fleece Jacket\"]"));
	}
	
	public WebElement imageTShirt() {
		return driver.findElement(By.cssSelector("img[alt=\"Test.allTheThings() T-Shirt (Red)\"]"));
	}
	
	public String getSrc(WebElement image) {
		return image.getDomAttribute("src");
	}
	
}
