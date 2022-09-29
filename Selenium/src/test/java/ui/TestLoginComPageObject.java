package ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.HomePage;
import pageobject.LoginPage;


class TestLoginComPageObject {

	private static WebDriver driver;
	
	/*
	@BeforeEach
	void setUp() throws Exception {
		
		driver = WebDriverManager.chromedriver().clearDriverCache().create();
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}*/

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
		
		LoginPage loginInPage = new LoginPage(driver);
		HomePage homePage = loginInPage.typeLogin("standard_user", "secret_sauce");
		WebElement imageBackpack = homePage.imageBackpack();
		assertEquals("/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", homePage.getSrc(imageBackpack));
	}
	
	@Test
	void loginWithLockedOutUser() {
		
		LoginPage loginInPage = new LoginPage(driver);
		loginInPage = loginInPage.typeLoginError("locked_out_user", "secret_sauce");
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginInPage.getMessageError());
	}
	
	@Test
	void loginWithProblemUser() {
		
		LoginPage loginInPage = new LoginPage(driver);
		HomePage homePage = loginInPage.typeLogin("problem_user", "secret_sauce");   
		String srcProblem = "/static/media/sl-404.168b1cce.jpg";
        
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
		
		LoginPage loginInPage = new LoginPage(driver);
		HomePage homePage = loginInPage.typeLogin("performance_glitch_user", "secret_sauce");
		WebElement imageBackpack = homePage.imageBackpack();
		assertEquals("/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", homePage.getSrc(imageBackpack));
		
	}

}
