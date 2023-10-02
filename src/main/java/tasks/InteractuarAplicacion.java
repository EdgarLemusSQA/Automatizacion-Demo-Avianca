package tasks;

import java.util.List;

import org.openqa.selenium.Keys;

import interactions.Escribir;
import interactions.EsperaImplicita;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Hit;
import uis.ExcelUis;

public class InteractuarAplicacion implements Task{
	
	private List<String> datos;

	public InteractuarAplicacion(List<String> datos) {
		this.datos = datos;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.BTN_CREAR_LIBRO_EN_BLANCO),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("A1"),
				Escribir.enExcel(datos.get(0)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("B1"),
				Escribir.enExcel(datos.get(1)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("C1"),
				Escribir.enExcel(datos.get(2)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("D1"),
				Escribir.enExcel(datos.get(3)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("A2"),
				Escribir.enExcel(datos.get(4)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("B2"),
				Escribir.enExcel(datos.get(5)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("C2"),
				Escribir.enExcel(datos.get(6)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("D2"),
				Escribir.enExcel(datos.get(7)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("A3"),
				Escribir.enExcel(datos.get(8)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("B3"),
				Escribir.enExcel(datos.get(9)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("C3"),
				Escribir.enExcel(datos.get(10)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("D3"),
				Escribir.enExcel(datos.get(11)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("A4"),
				Escribir.enExcel(datos.get(12)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("B4"),
				Escribir.enExcel(datos.get(13)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("C4"),
				Escribir.enExcel(datos.get(14)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("D4"),
				Escribir.enExcel(datos.get(15)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("A5"),
				Escribir.enExcel(datos.get(16)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("B5"),
				Escribir.enExcel(datos.get(17)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("C5"),
				Escribir.enExcel(datos.get(18)),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("D5"),
				Escribir.enExcel(datos.get(19)),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("A1"),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.BTN_NEGRITA),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("B1"),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.BTN_CURSIVA),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("C1"),
				Click.on(ExcelUis.BTN_RELLENO_COLOR),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("D1"),
				Click.on(ExcelUis.BTN_LETRA_COLOR),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.TXT_CELDA),
				Escribir.enExcel("A2"),				
//				Click.on(ExcelUis.TXT_TAMAÑO_FUENTE),
				Click.on(ExcelUis.TXT_TAMAÑO_FUENTE),
				DoubleClick.on(ExcelUis.TXT_TAMAÑO_FUENTE),
				Clear.field(ExcelUis.TXT_TAMAÑO_FUENTE),
				Escribir.enExcel("Barlow ExtraBold")
				);
	}

	public static InteractuarAplicacion deExcel(List<String> datos) {
		return Instrumented.instanceOf(InteractuarAplicacion.class).withProperties(datos);
	}
}
