package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.IndexedColors;

import cucumber.api.java.es.*;
import utils.Utilidades;

public class ExcelStepDefinitions {

	@Dado("^crea un archivo excel con el siguiente encabezado$")
	public void creaUnArchivoExcelConElSiguienteEncabezado(List<String> encabezados) {
		Utilidades.crearExcel();
		Utilidades.crearEncabezado(encabezados);
	}

	@Cuando("^cuando ingrese los siguiente datos$")
	public void cuandoIngreseLosSiguienteDatos(List<String> datos) {
		Utilidades.inicializarFIla(1);
		Utilidades.escribirExcel(0, datos.get(0));
		Utilidades.escribirExcel(1, datos.get(1));
		Utilidades.escribirExcel(2, datos.get(2));
		Utilidades.escribirExcel(3, datos.get(3));
		Utilidades.inicializarFIla(2);
		Utilidades.escribirExcel(0, datos.get(4));
		Utilidades.escribirExcel(1, datos.get(5));
		Utilidades.escribirExcel(2, datos.get(6));
		Utilidades.escribirExcel(3, datos.get(7));
		Utilidades.inicializarFIla(3);
		Utilidades.escribirExcel(0, datos.get(8));
		Utilidades.escribirExcel(1, datos.get(9));
		Utilidades.escribirExcel(2, datos.get(10));
		Utilidades.escribirExcel(3, datos.get(11));
		
		Utilidades.cambiarColorDeLetras(0, 0, IndexedColors.RED.getIndex());
		Utilidades.cambiarColorDeFondo(0, 1, IndexedColors.RED.getIndex());
		Utilidades.cambiarEstiloDeLetra(0, 2, true, true);
		Utilidades.cambiarFuenteDeLetra(0, 3, "Centaur", (short) 12);
	}

	@Entonces("^podra verificar la cantidad de datos en el archivo$")
	public void podraVerificarLaCantidadDeDatosEnElArchivo() throws IOException {
		assertEquals(Utilidades.leerDatosDeHojaDeExcel().size(), 3);
	}
}
