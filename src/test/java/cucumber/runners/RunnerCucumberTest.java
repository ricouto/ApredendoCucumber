package cucumber.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/cadastroContas.feature",
		glue = "cucumber.steps",
		//tags = "~@ignore",
		//tags = "@tipo1",
		//tags = "@tipo2",
		//tags = {"@tipo1, @tipo2"},
		//tags = "@ignore",
		plugin = {"pretty", "html:target/report-html", "json:target/report-json"},
		monochrome =  true, //false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class RunnerCucumberTest {
	
	protected static WebDriver driver = null;
	
	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ricardo.couto\\Documents\\automacaoWK\\driver\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");//("start-maximized");// 
		driver = new ChromeDriver(options);
		driver.get("http://srbarriga.herokuapp.com/logout");
		driver.findElement(By.id("email")).sendKeys("ricardo_macedo@hotmail.com");
		driver.findElement(By.id("senha")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	} 
}
