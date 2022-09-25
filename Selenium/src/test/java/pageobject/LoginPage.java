package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	protected WebDriver driver;
	private final String url = "https://www.saucedemo.com/";
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		
		navigate();
		
		if (!driver.getCurrentUrl().equals(url)) {
			throw new IllegalStateException("Esta não é a página de login");
		}
	}
	
	public LoginPage navigate() {
		driver.navigate().to(url);
		return this;
	}
	
	private WebElement loginBotton() {
		return driver.findElement(By.cssSelector("input[data-test=\"login-button\"]"));
	}
	
	private WebElement inputUsername() {
		return driver.findElement(By.cssSelector("input[data-test=\"username\"]"));
	}
	
	private WebElement inputPassword() {
		return driver.findElement(By.cssSelector("input[data-test=\"password\"]"));
	}
	
	private WebElement boxErrorLocator() {
		return driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
	}
	
	public String getMessageError() {
		return boxErrorLocator().getText();
	}
	
	public LoginPage typeUsername(String username) {
		inputUsername().clear();
		inputUsername().sendKeys(username);
		return this;
	}
	
	public LoginPage typePassword(String password) {
		inputPassword().clear();
		inputPassword().sendKeys(password);
		return this;
	}
	
	public HomePage submitLogin() {
		loginBotton().submit();
		
		return new HomePage(driver);
	}
	
	public LoginPage submitLoginExpectFailure() {
		loginBotton().submit();
		return this;
	}
	
	public HomePage typeLogin(String username, String password) {
		typeUsername(username);
		typePassword(password);
		return submitLogin();
	}
	
	public LoginPage typeLoginError(String username, String password) {
		typeUsername(username);
		typePassword(password);
		return submitLoginExpectFailure();
	}
	
}
