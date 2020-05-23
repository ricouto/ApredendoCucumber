package cucumber.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastroContasSteps {
	
	protected static WebDriver driver = null;
	
	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ricardo.couto\\Documents\\automacaoWK\\driver\\chromedriver.exe");	
		//driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");//("start-maximized");// 
		driver = new ChromeDriver(options);
		driver.get("http://srbarriga.herokuapp.com/logout");
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informoOUsuário(String arg1) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void aSenha(String arg1) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(arg1);
	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Entrar')]")).click();
	}

	@Então("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable {
	    Assert.assertEquals("Bem vindo, HiTech!", driver.findElement(By.xpath("//div[contains(text(),'Bem vindo, HiTech!')]")).getText());
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Contas')]")).click();
	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Adicionar')]")).click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Salvar')]")).click();
	}

	@Então("^a conta é inserida com sucesso$")
	public void aContaÉInseridaComSucesso() throws Throwable {
		Assert.assertEquals("Conta adicionada com sucesso!", driver.findElement(By.xpath("//div[contains(text(),'Conta adicionada com sucesso!')]")).getText());
	}
	
	@Então("^sou notificar que o nome da conta é obrigatório$")
	public void sou_notificar_que_o_nome_da_conta_é_obrigatório() throws Throwable {
		Assert.assertEquals("Informe o nome da conta", driver.findElement(By.xpath("//div[contains(text(),'Informe o nome da conta')]")).getText());
	}
	
	@Então("^sou notificado que já existe uma conta com esse nome$")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {
		Assert.assertEquals("Já existe uma conta com esse nome!", driver.findElement(By.xpath("//div[contains(text(),'Já existe uma conta com esse nome!')]")).getText());
	}
	
	@Então("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		Assert.assertEquals(arg1, driver.findElement(By.xpath("//div[starts-with(@class,'alert alert-')]")).getText());
	}
	
	@Before
	public void inicial() {
		//System.out.println("Comecando aqui .....");
	}
	
	@After
	public void fecharBrowser() {
		driver.quit();
	}

}
