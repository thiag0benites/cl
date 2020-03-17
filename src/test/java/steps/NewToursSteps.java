package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.NewToursPage;
import support.Hooks;

public final class NewToursSteps{

	NewToursPage newTours = new NewToursPage(Hooks.getDriver());
	
	@Dado("^que acesso o sistema$")
	public void queAcessoOSistema() throws Throwable {
		newTours.acessaSistema();
	}

	@Entao("^realizo login$")
	public void realizoLogin() throws Throwable {
		newTours.login();
	}

	@Quando("^preencho os dados da reserva \"([^\"]*)\"$")
	public void preenchoOsDadosDaReserva(String arg1, DataTable arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@Quando("^estou na tela \"([^\"]*)\"$")
	public void estouNaTela(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^seleciono o voo de ida \"([^\"]*)\"$")
	public void selecionoOVooDeIda(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^seleciono o voo de volta \"([^\"]*)\"$")
	public void selecionoOVooDeVolta(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^valido os dados de voo \"([^\"]*)\" e \"([^\"]*)\"$")
	public void validoOsDadosDeVooE(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^preencho os campos obrigatorios \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"$")
	public void preenchoOsCamposObrigatoriosE(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entao("^valido o numero de reserva$")
	public void validoONumeroDeReserva() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
