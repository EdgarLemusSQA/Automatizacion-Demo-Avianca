package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
	
	public static ArrayList<Map<String, String>> leerDatosDeHojaDeExcel() throws IOException {
		ArrayList<Map<String, String>> arrayListDatoPlanTrabajo = new ArrayList<Map<String, String>>();
        Map<String, String> informacionProyecto = new HashMap<String, String>();
        File file = new File(nombreExcel+".xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet("General");
        Iterator<Row> rowIterator = newSheet.iterator();
        Row titulos = rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.getColumnIndex();
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), String.valueOf((long) cell.getNumericCellValue()));
                        break;
                    case BLANK:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), "");
                        break;
                    default:
                }
            }
            arrayListDatoPlanTrabajo.add(informacionProyecto);
            informacionProyecto = new HashMap<String, String>();
        }
        return arrayListDatoPlanTrabajo;
	}

}
