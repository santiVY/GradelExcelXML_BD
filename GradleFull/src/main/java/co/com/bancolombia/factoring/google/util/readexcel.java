package co.com.bancolombia.factoring.google.util;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibm.icu.impl.UResource.Array;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class readexcel{
	
	static FileInputStream agenda;
	static FileOutputStream outPut;
	static XSSFWorkbook wb;
	static String ruta = "C:\\Users\\santiago.velez\\Documents\\GitHub\\Retos de Johan\\Retos\\GradleFull\\agenda.xlsx";
	static File archivo = new File(ruta);
	static Sheet sheet;
	//static Workbook workbook;

	public static void leerExcel() {
		try {
			agenda = new FileInputStream(new File(ruta));
			wb = new XSSFWorkbook(agenda);			
			sheet = wb.getSheetAt(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}		
	
	public List<String> Obtenernombres()
	{
		leerExcel();
		ArrayList<String> nombres= new ArrayList<String>();
		Iterator<Row> filas = sheet.iterator();
		while(filas.hasNext()) {
			Row fila = filas.next();
			Iterator<Cell> celdas = fila.iterator();										
			while(celdas.hasNext()) {
				Cell celda = celdas.next();	
				
				nombres.add(celda.getStringCellValue());			
			}
			
		}
		try {
			agenda.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombres;					
	}
	
	public void escribirExcel(ArrayList<String> nombres, ArrayList<String> estados) {
		
		XSSFWorkbook libro = new XSSFWorkbook();
		// Se crea una hoja dentro del libro
		
		XSSFSheet hoja = libro.createSheet();
		// Se crea una fila dentro de la hoja
		
		Row fila;

		// Se crea una celda dentro de la fila
		Cell celda;
		int f = 0;
		
		// Se crea el contenido de la celda y se mete en ella.
		//XSSFRichTextString texto = new XSSFRichTextString("texto");
		
		for(String nombre: nombres) {
			fila = hoja.createRow(f);
			celda = fila.createCell((short) 0);
			celda.setCellValue(nombre);
			f++;
		}
		
		
		for(String estado: estados) {
			fila = hoja.getRow((f+1)-f);
			celda = fila.getCell((short) 1);
			celda.setCellValue(estado);
			f++;
		}
		
		// Se salva el libro.
		
		try {
			FileOutputStream elFichero = new FileOutputStream("ResultadoBusquedaNombres.xlsx");
			libro.write(elFichero);
			libro.close();
			elFichero.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}

	}
	
//	//Intentando escribir en un excel
//	public void  prerararExcel() {
//		try {
//			
//			outPut = new FileOutputStream(archivo);
//			System.out.println("Archivo de excel preparado pra la lectura");
//			crearEnlace();
//			
//		} catch (Exception e) {
//			System.out.println("Archivo de excel no esta preparado pra la lectura");
//		}
//	}
//	
//	public void escribirExcel(int row, String estado) {
//		System.out.println("voy a prepara la hoja");
//		Sheet hoja = workbook.getSheetAt(0);
//		System.out.println("voy a preprar la fila");
//		Row rowWrite = hoja.getRow(row);
//		System.out.println("voy a prepara la celda");
//		Cell cellWrite = rowWrite.createCell(1);
//		System.out.println("voy a insertar el valor");
//		cellWrite.setCellValue(estado);
//		System.out.println("se inserto el valor");
//	}
//	
//	public void guardarExcel() {
//		try {
//			workbook.write(outPut);
//			workbook.close();
//		} catch (Exception e) {
//			System.out.println("No guardo correctamente verifique");
//		}
//	}
//	
//	private void crearEnlace() {
//		try {
//			agenda = new FileInputStream(new File(ruta));
//			workbook = WorkbookFactory.create(agenda);
//		} catch (Exception e) {
//			System.out.println("El archivo no fue creado");
//		}
//	}
	
	
}



