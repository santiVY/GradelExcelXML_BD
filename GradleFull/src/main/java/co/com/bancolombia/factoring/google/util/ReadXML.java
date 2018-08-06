package co.com.bancolombia.factoring.google.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.collections4.iterators.NodeListIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {
	
	public  Document document = null;
	
	
	public ReadXML(String ruta) {
		
			try {
				File archivo = new File(ruta);
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
				document = documentBuilder.parse(archivo);
				document.getDocumentElement().normalize();
				System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
			
	}
	
	
	
	public ArrayList<String> getDataList(){
		ArrayList<String> Lista = new ArrayList<>();
		NodeList listaEmpleados = document.getElementsByTagName("empleado");
        for (int temp = 0; temp < listaEmpleados.getLength(); temp++) {
            Node nodo = listaEmpleados.item(temp);
            System.out.println("Elemento:" + nodo.getNodeName());
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodo;
                Lista.add(element.getElementsByTagName("nombre").item(0).getTextContent());
            }
	
        }
        return Lista;
	}
}
	
	
	
	
	
	
	
	
	
	
//	public static NodeList listaEmpleados;
//	public static NodeList XML() {
//        try {
//            File archivo = new File("C:\\Users\\santiago.velez\\Documents\\GitHub\\Retos de Johan\\Retos\\GradleFull/datos.xml");
//            System.out.println("Entro al xml para leer");
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
//            Document document = documentBuilder.parse(archivo);
//            document.getDocumentElement().normalize();
//            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
//            listaEmpleados = document.getElementsByTagName("empleado");              
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listaEmpleados; 
//    }
	

