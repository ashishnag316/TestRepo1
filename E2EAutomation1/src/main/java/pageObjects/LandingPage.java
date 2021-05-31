package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	//constructor
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By loginBtn =  By.xpath("//span[text()='Login']");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	//private By header=By.cssSelector("div[class*='video-banner'] h3");
	
	public LoginPage loginBtn()
	{
		driver.findElement(loginBtn).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
		
	}
	
	public WebElement title() {
		return driver.findElement(title);
	}
	
	public WebElement navBar()
	{
		return driver.findElement(navBar);
	}
	public List<WebElement> getPopupSize()
	{
		return driver.findElements(popup);
	}
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
}