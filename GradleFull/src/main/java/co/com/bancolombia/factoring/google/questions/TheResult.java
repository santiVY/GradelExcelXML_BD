package co.com.bancolombia.factoring.google.questions;

import co.com.bancolombia.factoring.google.user_interfaces.FacebookHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class TheResult implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(FacebookHomePage.title).viewedBy(actor).asString();
	}

	public static TheResult is() {
		// TODO Auto-generated method stub
		return new TheResult();
	}

}
