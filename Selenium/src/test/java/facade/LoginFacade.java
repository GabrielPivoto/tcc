package facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebElement;

import pageobject.HomePage;
import pageobject.LoginPage;

public class LoginFacade {
	private HomePage homePage;
	private LoginPage loginPage;
	
	public LoginFacade(LoginPage loginPage) {
		super();
		this.loginPage = loginPage;
	}
	
	public HomePage verifyLoginFacade(String username, String password, String srcImage) {
		homePage = loginPage.typeLogin(username, password);
		WebElement imageBackpack = homePage.imageBackpack();
		assertEquals(srcImage, homePage.getSrc(imageBackpack));
		
		return homePage;
	}
	
}
