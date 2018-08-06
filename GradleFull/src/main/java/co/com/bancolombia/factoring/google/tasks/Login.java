package co.com.bancolombia.factoring.google.tasks;

import co.com.bancolombia.factoring.google.user_interfaces.FacebookLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Login implements Task{
	private String email;
	private String pass;
		
	
	public Login(String email, String pass) {		
		this.email = email;
		this.pass = pass;
	}



	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(email).into(FacebookLoginPage.email_field),
				Enter.theValue(pass).into(FacebookLoginPage.pass_field),
				Click.on(FacebookLoginPage.login)
		);
		
	}
	
	public static Login login(String email, String pass) {
		return instrumented(Login.class,email,pass);
	}

}
