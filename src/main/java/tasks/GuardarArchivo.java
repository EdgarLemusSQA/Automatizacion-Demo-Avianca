package tasks;

import java.util.List;

import org.openqa.selenium.Keys;

import interactions.Escribir;
import interactions.EsperaImplicita;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import uis.ExcelUis;

public class GuardarArchivo implements Task{

	private List<String> informacion;

	public GuardarArchivo(List<String> informacion) {
		this.informacion = informacion;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.BTN_ARCHIVO),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.BTN_GUARDAR),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.BTN_EXAMINAR),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.TXT_UBICACION),
				Escribir.enExcel(informacion.get(0)),
				EsperaImplicita.enPantalla(),
				Click.on(ExcelUis.TXT_NOMBRE_ARCHIVO),
				Escribir.enExcel(informacion.get(1))
				);
	}

	public static GuardarArchivo enLaRuta(List<String> informacion) {
		return Instrumented.instanceOf(GuardarArchivo.class).withProperties(informacion);
	}
}
