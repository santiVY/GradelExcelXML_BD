package co.com.bancolombia.factoring.google.step_definition;

import java.util.HashMap;
import java.util.Map;

//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import co.com.bancolombia.factoring.google.tasks.BuscarAmigos;
import co.com.bancolombia.factoring.google.tasks.Login;
import co.com.bancolombia.factoring.google.tasks.OpenTheBrowser;
import co.com.bancolombia.factoring.google.user_interfaces.FacebookLoginPage;
import co.com.bancolombia.factoring.google.util.ReadXML;
import co.com.bancolombia.factoring.google.util.Tab;
import co.com.bancolombia.factoring.google.util.agendaDB;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;


public class GoogleTranslateStepDefinitions {
	
	@Managed(driver = "chrome")
	private WebDriver herBrowser;
	private Actor santiago = Actor.named("Santiago");
	//private GoogleHomePage googleHomePage;
	private FacebookLoginPage facebookloginpage;	
	//agendaDB db = new agendaDB();
	
	
	@Before
	public void setup() {
		
		Map<String, Object> prefs = new HashMap<String, Object>();
//		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		herBrowser = new ChromeDriver(options); 
		santiago.can(BrowseTheWeb.with(herBrowser));   // Se le asigna el driver al actor
		herBrowser.manage().window().maximize();	
	}
	
	// wasAbleTo (given) (Precondicion) - attemptsTo (when)  (Condicion)
	
	@Given("^that (.*) opened her browser at facebook (.*)$")
	public void thatTheUserOpenedTheBrowserAt(String name, String webpage) throws Exception {
		santiago.wasAbleTo(OpenTheBrowser.at(facebookloginpage));   
	}

	@When("^inicia sesion en facebook (.*) y (.*)$")
	public void sheGoesFacebook(String email,String pass) throws Exception {
		santiago.attemptsTo(Login.login(email, pass));
		Tab t =new Tab();
		t.tab();
	}

	@When("^busca los nombres contenidos en el archivo excel$")
	public void sheSearchFriends() throws Exception {
		santiago.attemptsTo(BuscarAmigos.buscaramigos());
	}



}
