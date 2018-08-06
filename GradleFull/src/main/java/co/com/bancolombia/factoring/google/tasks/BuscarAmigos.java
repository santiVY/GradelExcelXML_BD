package co.com.bancolombia.factoring.google.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import co.com.bancolombia.factoring.google.questions.TheResult;
import co.com.bancolombia.factoring.google.user_interfaces.FacebookHomePage;
import co.com.bancolombia.factoring.google.util.ReadXML;
import co.com.bancolombia.factoring.google.util.agendaDB;
import co.com.bancolombia.factoring.google.util.readexcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

public class BuscarAmigos implements Task{	
	private static String n;
	readexcel ex = new readexcel();	
	List<String> nombres =  ex.Obtenernombres();
	//List<String> nombresdb =  agendaDB.ObtenerNombresAgenda();
	//List<String> NewFriend = new ArrayList<String>();
	//static ArrayList<String> x = new ArrayList<>();
	//TheResult r = new TheResult();
	
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		//leer desde une Excel 
		System.out.println("Consulta de excel: " + nombres);
		
		
		ArrayList<String> nombr = new ArrayList<String>();
		ArrayList<String> estad = new ArrayList<String>();
		
		for (String nombre : nombres) {
			
			actor.attemptsTo(
					Enter.theValue(nombre).into(FacebookHomePage.Input_Search),
					Click.on(FacebookHomePage.search),
					Click.on(FacebookHomePage.result)
					);
			
			String perfil = TheResult.is().answeredBy(actor).toString().split(Pattern.quote("("))[0];
			System.out.println(perfil);
			
			nombr.add(nombre);
			if(perfil.equalsIgnoreCase(nombre)) {
				estad.add("Lo encontro");
			}else {
				estad.add("No Lo encontro");
			}
		
		}
		
		ex.escribirExcel(nombr, estad);
		
		//ex.guardarExcel();
		
		
		
		//Leer desde una base de datos
		
		/*System.out.println("consulta"+nombresdb);
		
		for (String nombre : nombresdb) {	
			actor.attemptsTo(
					Enter.theValue(nombre).into(FacebookHomePage.Input_Search),
					Click.on(FacebookHomePage.search),
					Click.on(FacebookHomePage.result)
					);
			
			n = Text.of(FacebookHomePage.title).viewedBy(actor).asString();
			if (nombre.equals(n)) {
				System.out.println(nombre+" === "+n);
				agendaDB.insertarcomprobacion("Si lo encontro", nombre);
			}else {
				System.out.println(nombre+" <> "+n);
				agendaDB.insertarcomprobacion("NO lo encontro", nombre);
				NewFriend.add(n);			
			}
			
		}
		
		for (String friend : NewFriend) {
			System.out.println("amigo nuevo" + friend);
			agendaDB.intoNewElement("Nuevo amigo", friend);
		}*/
		
		
		//Leer desde un XML
		/*ReadXML file = new ReadXML("datos.xml");
		ArrayList<String> nombres = file.getDataList();
		
		System.out.println("el archivo del xml: " + nombres);
		
		for (String nombre : nombres) {
			actor.attemptsTo(
					Enter.theValue(nombre).into(FacebookHomePage.Input_Search),
					Click.on(FacebookHomePage.search),
					Click.on(FacebookHomePage.result)
	
			);
		}*/
	}
	


	public static BuscarAmigos buscaramigos() {
		return instrumented(BuscarAmigos.class);	
	}
}
