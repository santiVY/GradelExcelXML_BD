package co.com.bancolombia.factoring.google.user_interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.facebook.com")
public class FacebookLoginPage extends PageObject{
	public static final Target email_field = Target.the("Facebook email").located(By.id("email"));
	public static final Target pass_field = Target.the("Facebook pass").located(By.xpath("//input[@id='pass']"));
	public static final Target login = Target.the("Facebook login").located(By.xpath("//label[@id=\"loginbutton\"]"));		
}
