package pages;

import support.DriverQA;
import support.Hooks;

public class NewToursPage {
	
    private DriverQA driver;

    public NewToursPage(DriverQA driver) {
        this.driver = driver;
    }

    private String envUrl = "http://www.newtours.demoaut.com/";
    
    private String nameUsuario = "userName";
    private String nameSenha = "password";
    private String nameLogin = "login";
    private String nameValidacao = "tripType";
    
    public void acessaSistema() {
    	driver.openURL(envUrl);
    }
    
	public void login() {
		driver.sendKeys("mercury", nameUsuario, "name");
		driver.sendKeys("mercury", nameSenha, "name");
		driver.click(nameLogin, "name");
		driver.waitElementAll(nameValidacao, "name");
		driver.escreveRelatorio(Hooks.getCenario(), true, "Teste Print", true);
	}
}
