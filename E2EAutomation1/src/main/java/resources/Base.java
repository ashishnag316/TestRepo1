package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {
	
		public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);//load the file
		//mvn test -Dbrowser=chrome
		//String browserName = System.getProperty("browser");//use this to excecute from jenkins
		String browserName = prop.getProperty("browser");// comment this line if you are sending parameter from Maven
		System.out.println(browserName);
		//initialize the browser
		if(browserName.equals("chrome"))
		{
			//call chrome browser
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("--headless");
			}
			
			driver = new ChromeDriver(options);
		}
		else if (browserName.equals("firefox"))
		{
			//call FF browser
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--headless");
			driver = new FirefoxDriver(options1);
		}
		else if(browserName.equals("edge"))
		{
			//call Edge browser
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
			//EdgeOptions options3 = new EdgeOptions();
			//options3.addArguments("headless");//available in selenium 4 
			driver = new EdgeDriver();
			
		}
		
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
		
	}
	public String getScreenshotPath(String testMethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot ss = ((TakesScreenshot) driver);
		File src = ss.getScreenshotAs(OutputType.FILE);
		String dest = (System.getProperty("user.dir")+"\\reports\\"+testMethodName+".png");
		File dest1 = new File(dest);
		FileUtils.copyFile(src, dest1);
		return dest;
		
	}
	

}
