package utils;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilidades {
	
	public static Workbook book;
	public static Sheet libro;
	public static FileOutputStream fileout;
	public static Row filas;
	public static String nombreExcel = "Automatizacion Datos Avianca";

	public static void crearExcel() {
		book = new XSSFWorkbook();
		libro = book.createSheet("General");		
		archivoExcel();		
	}
	
	public static void inicializarFIla(int fila) {
		filas = libro.createRow(fila);
	}
	
	public static void escribirExcel(int celda, Object valor) {		
		filas.createCell(celda).setCellValue(String.valueOf(valor));
		archivoExcel();	
	}
	
	private static void archivoExcel() {
		try {
			fileout = new FileOutputStream(nombreExcel+".xlsx");
			book.write(fileout);
			fileout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void crearEncabezado(List<String> encabezados) {
		inicializarFIla(0);
		escribirExcel(0, encabezados.get(0));
		escribirExcel(1, encabezados.get(1));
		escribirExcel(2, encabezados.get(2));
		escribirExcel(3, encabezados.get(3));
	}
	
	public static void crearHojaDeExcel(String hojaExcel) {
		libro = book.createSheet(hojaExcel);
		archivoExcel();	
	}
	

}
