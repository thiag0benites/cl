package support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	private static DriverQA driver;
	private static Scenario cenario;

	@Before
	public void ConfiguracaoInicial(Scenario cenario) {
		Hooks.cenario = cenario;
		System.out.println("*** Iniciando Teste ***");
		System.out.println("Executando cenario " + cenario.getName());
    	driver = new DriverQA(cenario);
        driver.start("chrome");
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void FecharJanela() {
		driver.quit();
		System.out.println("*** Fim dos testes ***");	
	}
	
	public static DriverQA getDriver() {
		return driver;
	}
	
	public static Scenario getCenario() {
		return cenario;
	}
}
