package ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import facade.LoginFacade;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.HomePage;
import pageobject.LoginPage;

class TestLoginComPageObjectComFacade {
	
	private static WebDriver driver;
	private static LoginPage loginPage;
	private static LoginFacade loginFacade;
	private static HomePage homePage;
	
	/*
	@BeforeEach
	void setUp() throws Exception {
	
		driver = WebDriverManager.chromedriver().clearDriverCache().create();
		loginPage = new LoginPage(driver);
		loginFacade = new LoginFacade(loginPage);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}*/
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
		driver = WebDriverManager.chromedriver().clearDriverCache().create();
		loginPage = new LoginPage(driver);
		loginFacade = new LoginFacade(loginPage);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		loginFacade = new LoginFacade(loginPage);
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@Test
	void loginWithStandardUser() {
		loginFacade.verifyLoginFacade("standard_user", "secret_sauce", "/static/media/sauce-backpack-1200x1500.34e7aa42.jpg");
	}
	
	@Test
	void loginWithLockedOutUser() {
		
		loginPage = loginPage.typeLoginError("locked_out_user", "secret_sauce");
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getMessageError());
	}
	
	@Test
	void loginWithProblemUser() {
		
		String srcProblem = "/static/media/sl-404.168b1cce.jpg";
		homePage = loginFacade.verifyLoginFacade("problem_user", "secret_sauce", srcProblem);
		
		WebElement image = homePage.imageBackpack();
        assertEquals(srcProblem, homePage.getSrc(image));
        
        image = homePage.imageBike();
        assertEquals(srcProblem, homePage.getSrc(image));
        
        image = homePage.imageBolt();
        assertEquals(srcProblem, homePage.getSrc(image));
        
        image = homePage.imageFleece();
        assertEquals(srcProblem, homePage.getSrc(image));
        
        image = homePage.imageOnesie();
        assertEquals(srcProblem, homePage.getSrc(image));
        
        image = homePage.imageTShirt();
        assertEquals(srcProblem, homePage.getSrc(image));
	}

	@Test
	void loginWithPerformanceGlitchUser() {
		
		loginFacade.verifyLoginFacade("performance_glitch_user", "secret_sauce", "/static/media/sauce-backpack-1200x1500.34e7aa42.jpg");
		
	}
}
