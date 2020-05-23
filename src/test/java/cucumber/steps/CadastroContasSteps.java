package cucumber.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastroContasSteps {
	
	protected static WebDriver driver = null;
	
	@Dado("^que desejo adicionar uma conta$")
	public void queDesejoAdicionarUmaConta() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ricardo.couto\\Documents\\automacaoWK\\driver\\chromedriver.exe");	
		//driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");//("start-maximized");// 
		driver = new ChromeDriver(options);
		driver.get("http://srbarriga.herokuapp.com/logout");
		
		driver.findElement(By.id("email")).sendKeys("ricardo_macedo@hotmail.com");
		driver.findElement(By.id("senha")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();
		
		//Assert.assertEquals("Bem vindo, HiTech!", driver.findElement(By.xpath("//div[contains(text(),'Bem vindo, HiTech!')]")).getText());
		
		driver.findElement(By.xpath("//a[contains(text(),'Contas')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Adicionar')]")).click();
	}

	@Quando("^adiciono a conta \"([^\"]*)\"$")
	public void adicionoAConta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
		driver.findElement(By.xpath("//button[contains(text(),'Salvar')]")).click();
	}
	
	
	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ricardo.couto\\Documents\\automacaoWK\\driver\\chromedriver.exe");	
		//driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");//("start-maximized");// 
		driver = new ChromeDriver(options);
		driver.get("http://srbarriga.herokuapp.com/logout");
	}

	@Então("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		Assert.assertEquals(arg1, driver.findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText());
	}
	
	@Before //a order no Before eh o contrario comeca no mais baixo i.e. - 0 ate 10
	public void inicial() {
		//System.out.println("Comecando aqui .....");
	}
	
	@After(order = 1, value = "@funcional")
	public void screenshot(Scenario cenario) {
		String destinationPath = null;
		
		try {
			String pathScreenShot = System.getProperty("user.dir");
			destinationPath = pathScreenShot + "\\target\\screenshot\\" + cenario.getName() +"."+ System.nanoTime() +".jpg";
			//System.out.println(destinationPath);
		
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(file, new File (destinationPath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0, value = "@funcional")
	public void fecharBrowser() {
		driver.quit();
	}

}
