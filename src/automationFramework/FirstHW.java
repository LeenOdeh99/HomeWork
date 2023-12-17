package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstHW {

	public static void elementIsDisplayed(String elementName, String className, WebDriver driver) {
		WebElement element = driver.findElement(By.className(className));
		Boolean isDisplayed = element !=null ? element.isDisplayed() : false;
		if(isDisplayed) {
			System.out.println(elementName + " is Displayed");
		} else {
			System.out.println(elementName + " isn't displayed");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lancome-usa.com/");
		driver.manage().window().maximize();

		elementIsDisplayed("Logo", "c-logo__image", driver);
		elementIsDisplayed("Email", "c-simple-signup__title", driver);
		elementIsDisplayed("My Account", "c-user__link-icon", driver);
		elementIsDisplayed("Cart icon", "c-minicart-icon__svg", driver);
		
		WebElement elementClick = driver.findElement(By.className("c-user__link"));
		elementClick.click();
//		driver.get("https://www.lancome-usa.com/account");
//		driver.manage().window().maximize();
		WebElement loginFormTitle = driver.findElement(By.className("c-account__title"));
		String title = loginFormTitle.getText();
		if (title.equals("Sign In")) {
			System.out.println("Title of login form equal to Sign In");
		} else {
			System.out.println("Title of login form not equal to Sign In");
		}
		
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys("test1@live.com");
		
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("Test@123");
		
		WebElement loginButton = driver.findElement(By.name("submit"));
		loginButton.click();
		
		WebElement userName = driver.findElement(By.className("c-account__user-name"));
		String name = userName.getText();
		
		String firstName = "Test";
		if(name.contains(firstName)) {
			System.out.println("The user is logged in successfully");
		} else {
			System.out.println("User login failed");
		}

	}

}
