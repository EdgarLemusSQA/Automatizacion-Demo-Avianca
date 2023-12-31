package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilidades {

	private  static Robot robot;
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
	
	public static String ejecutarCMD(String cmd) {
		String respuesta = "";
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmd);
		builder.redirectErrorStream(true);
		Process p = null;
		try {
			p = builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		while (true) {
			try {
				line = r.readLine();
				if (line != null) {
					respuesta = respuesta + line + "\n";
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			if (line == null) {
				break;
			}
		}
		return respuesta;
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
			fileout = new FileOutputStream(nombreExcel + ".xlsx");
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
		File file = new File(nombreExcel + ".xlsx");
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
					informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(),
							cell.getStringCellValue());
					break;
				case NUMERIC:
					informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(),
							String.valueOf((long) cell.getNumericCellValue()));
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

	public static void cambiarColorDeLetras(int fila, int celda, short colorIndex) {
		CellStyle estilo = libro.getWorkbook().createCellStyle();
		Font fuente = libro.getWorkbook().createFont();

		fuente.setColor(colorIndex);

		estilo.setFont(fuente);

		Row filaSeleccionada = libro.getRow(fila);
		if (filaSeleccionada == null) {
			filaSeleccionada = libro.createRow(fila);
		}
		Cell celdaSeleccionada = filaSeleccionada.getCell(celda);
		if (celdaSeleccionada == null) {
			celdaSeleccionada = filaSeleccionada.createCell(celda);
		}

		celdaSeleccionada.setCellStyle(estilo);

		archivoExcel();
	}

	public static void cambiarColorDeFondo(int fila, int celda, short colorIndex) {
		CellStyle estilo = libro.getWorkbook().createCellStyle();
		estilo.setFillForegroundColor(colorIndex);
		estilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Row filaSeleccionada = libro.getRow(fila);
		if (filaSeleccionada == null) {
			filaSeleccionada = libro.createRow(fila);
		}
		Cell celdaSeleccionada = filaSeleccionada.getCell(celda);
		if (celdaSeleccionada == null) {
			celdaSeleccionada = filaSeleccionada.createCell(celda);
		}

		celdaSeleccionada.setCellStyle(estilo);

		archivoExcel();
	}

	public static void cambiarEstiloDeLetra(int fila, int celda, boolean negrita, boolean cursiva) {
		CellStyle estilo = libro.getWorkbook().createCellStyle();
		Font fuente = libro.getWorkbook().createFont();

		fuente.setBold(negrita);
		fuente.setItalic(cursiva);

		estilo.setFont(fuente);

		Row filaSeleccionada = libro.getRow(fila);
		if (filaSeleccionada == null) {
			filaSeleccionada = libro.createRow(fila);
		}
		Cell celdaSeleccionada = filaSeleccionada.getCell(celda);
		if (celdaSeleccionada == null) {
			celdaSeleccionada = filaSeleccionada.createCell(celda);
		}

		celdaSeleccionada.setCellStyle(estilo);

		archivoExcel();
	}

	public static void cambiarFuenteDeLetra(int fila, int celda, String nombreFuente, short tamañoFuente) {
		CellStyle estilo = libro.getWorkbook().createCellStyle();
		Font fuente = libro.getWorkbook().createFont();

		fuente.setFontName(nombreFuente);

		fuente.setFontHeightInPoints(tamañoFuente);

		estilo.setFont(fuente);

		Row filaSeleccionada = libro.getRow(fila);
		if (filaSeleccionada == null) {
			filaSeleccionada = libro.createRow(fila);
		}
		Cell celdaSeleccionada = filaSeleccionada.getCell(celda);
		if (celdaSeleccionada == null) {
			celdaSeleccionada = filaSeleccionada.createCell(celda);
		}

		celdaSeleccionada.setCellStyle(estilo);

		archivoExcel();
	}

	public static void escribir(String texto) {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < texto.length(); i++){
            switch (texto.charAt(i)){
                case '1':
                    robot.keyPress(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_1);
                    break;
                case '2':
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    break;
                case '3':
                    robot.keyPress(KeyEvent.VK_3);
                    robot.keyRelease(KeyEvent.VK_3);
                    break;
                case '4':
                    robot.keyPress(KeyEvent.VK_4);
                    robot.keyRelease(KeyEvent.VK_4);
                    break;
                case '5':
                    robot.keyPress(KeyEvent.VK_5);
                    robot.keyRelease(KeyEvent.VK_5);
                    break;
                case '6':
                    robot.keyPress(KeyEvent.VK_6);
                    robot.keyRelease(KeyEvent.VK_6);
                    break;
                case '7':
                    robot.keyPress(KeyEvent.VK_7);
                    robot.keyRelease(KeyEvent.VK_7);
                    break;
                case '8':
                    robot.keyPress(KeyEvent.VK_8);
                    robot.keyRelease(KeyEvent.VK_8);
                    break;
                case '9':
                    robot.keyPress(KeyEvent.VK_9);
                    robot.keyRelease(KeyEvent.VK_9);
                    break;
                case '0':
                    robot.keyPress(KeyEvent.VK_0);
                    robot.keyRelease(KeyEvent.VK_0);
                    break;
                case 'Q':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_Q);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_Q);
                    break;
                case 'W':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_W);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_W);
                    break;
                case 'E':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_E);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_E);
                    break;
                case 'R':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_R);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_R);
                    break;
                case 'T':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_T);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_T);
                    break;
                case 'Y':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_Y);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_Y);
                    break;
                case 'U':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_U);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_U);
                    break;
                case 'I':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_I);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_I);
                    break;
                case 'O':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_O);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_O);
                    break;
                case 'P':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_P);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_P);
                    break;
                case 'S':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_S);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_S);
                    break;
                case 'D':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_D);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_D);
                    break;
                case 'F':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_F);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_F);
                    break;
                case 'G':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_G);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_G);
                    break;
                case 'H':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_H);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_H);
                    break;
                case 'J':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_J);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_J);
                    break;
                case 'K':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_K);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_K);
                    break;
                case 'L':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_L);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_L);
                    break;
                case 'Z':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_Z);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_Z);
                    break;
                case 'X':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_X);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_X);
                    break;
                case 'C':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_C);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_C);
                    break;
                case 'V':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_V);
                    break;
                case 'B':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_B);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_B);
                    break;
                case 'N':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_N);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_N);
                    break;
                case 'M':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_M);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_M);
                    break;
                case 'A':
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_A);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_A);
                    break;
                case 'q':
                    robot.keyPress(KeyEvent.VK_Q);
                    robot.keyRelease(KeyEvent.VK_Q);
                    break;
                case 'w':
                    robot.keyPress(KeyEvent.VK_W);
                    robot.keyRelease(KeyEvent.VK_W);
                    break;
                case 'e':
                    robot.keyPress(KeyEvent.VK_E);
                    robot.keyRelease(KeyEvent.VK_E);
                    break;
                case 'r':
                    robot.keyPress(KeyEvent.VK_R);
                    robot.keyRelease(KeyEvent.VK_R);
                    break;
                case 't':
                    robot.keyPress(KeyEvent.VK_T);
                    robot.keyRelease(KeyEvent.VK_T);
                    break;
                case 'y':
                    robot.keyPress(KeyEvent.VK_Y);
                    robot.keyRelease(KeyEvent.VK_Y);
                    break;
                case 'u':
                    robot.keyPress(KeyEvent.VK_U);
                    robot.keyRelease(KeyEvent.VK_U);
                    break;
                case 'i':
                    robot.keyPress(KeyEvent.VK_I);
                    robot.keyRelease(KeyEvent.VK_I);
                    break;
                case 'o':
                    robot.keyPress(KeyEvent.VK_O);
                    robot.keyRelease(KeyEvent.VK_O);
                    break;
                case 'p':
                    robot.keyPress(KeyEvent.VK_P);
                    robot.keyRelease(KeyEvent.VK_P);
                    break;
                case 'a':
                    robot.keyPress(KeyEvent.VK_A);
                    robot.keyRelease(KeyEvent.VK_A);
                    break;
                case 's':
                    robot.keyPress(KeyEvent.VK_S);
                    robot.keyRelease(KeyEvent.VK_S);
                    break;
                case 'd':
                    robot.keyPress(KeyEvent.VK_D);
                    robot.keyRelease(KeyEvent.VK_D);
                    break;
                case 'f':
                    robot.keyPress(KeyEvent.VK_F);
                    robot.keyRelease(KeyEvent.VK_F);
                    break;
                case 'g':
                    robot.keyPress(KeyEvent.VK_G);
                    robot.keyRelease(KeyEvent.VK_G);
                    break;
                case 'h':
                    robot.keyPress(KeyEvent.VK_H);
                    robot.keyRelease(KeyEvent.VK_H);
                    break;
                case 'j':
                    robot.keyPress(KeyEvent.VK_J);
                    robot.keyRelease(KeyEvent.VK_J);
                    break;
                case 'k':
                    robot.keyPress(KeyEvent.VK_K);
                    robot.keyRelease(KeyEvent.VK_K);
                    break;
                case 'l':
                    robot.keyPress(KeyEvent.VK_L);
                    robot.keyRelease(KeyEvent.VK_L);
                    break;
                case 'z':
                    robot.keyPress(KeyEvent.VK_Z);
                    robot.keyRelease(KeyEvent.VK_Z);
                    break;
                case 'x':
                    robot.keyPress(KeyEvent.VK_X);
                    robot.keyRelease(KeyEvent.VK_X);
                    break;
                case 'c':
                    robot.keyPress(KeyEvent.VK_C);
                    robot.keyRelease(KeyEvent.VK_C);
                    break;
                case 'v':
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_V);
                    break;
                case 'b':
                    robot.keyPress(KeyEvent.VK_B);
                    robot.keyRelease(KeyEvent.VK_B);
                    break;
                case 'n':
                    robot.keyPress(KeyEvent.VK_N);
                    robot.keyRelease(KeyEvent.VK_N);
                    break;
                case 'm':
                    robot.keyPress(KeyEvent.VK_M);
                    robot.keyRelease(KeyEvent.VK_M);
                    break;
                case '*':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD2);
                    robot.keyRelease(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD2);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '@':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD6);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyRelease(KeyEvent.VK_NUMPAD6);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '.':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD6);
                    robot.keyRelease(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD6);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '/':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD7);
                    robot.keyRelease(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD7);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '-':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD5);
                    robot.keyRelease(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD5);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '+':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyRelease(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case ',':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyRelease(KeyEvent.VK_NUMPAD4);
                    robot.keyPress(KeyEvent.VK_NUMPAD4);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '!':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyRelease(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '$':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD6);
                    robot.keyRelease(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD6);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '#':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD5);
                    robot.keyRelease(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD5);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '%':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD7);
                    robot.keyRelease(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD7);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case '&':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD8);
                    robot.keyRelease(KeyEvent.VK_NUMPAD3);
                    robot.keyPress(KeyEvent.VK_NUMPAD8);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case ' ':
                    robot.keyPress(KeyEvent.VK_SPACE);
                    robot.keyRelease(KeyEvent.VK_SPACE);
                    break;

                case '\\':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD9);
                    robot.keyPress(KeyEvent.VK_NUMPAD2);
                    robot.keyRelease(KeyEvent.VK_NUMPAD9);
                    robot.keyPress(KeyEvent.VK_NUMPAD2);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case ':':
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_NUMPAD5);
                    robot.keyPress(KeyEvent.VK_NUMPAD8);
                    robot.keyRelease(KeyEvent.VK_NUMPAD5);
                    robot.keyPress(KeyEvent.VK_NUMPAD8);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
            }
        }
		
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
