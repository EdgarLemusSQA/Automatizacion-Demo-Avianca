package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import drivers.DriverWindows;
import interactions.Escribir;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.EscribirTexto;
import tasks.GuardarArchivo;
import tasks.InteractuarAplicacion;
import uis.ExcelUis;
import utils.Utilidades;

public class PocStepsDefinitios {

	@Before
    public void before() throws IOException {
		if (DriverWindows.windowsSession != null) {
	        DriverWindows.windowsSession.quit();
	    }
        OnStage.setTheStage(new OnlineCast());
    }
	
	@Dado("^que el abre un archivo excel$")
	public void queElAbreUnArchivoExcel() {
		OnStage.theActorCalled("").can(BrowseTheWeb.with(DriverWindows.windowsHisDriver("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE").on()));
	}


	@Cuando("^cuando ingrese los datos$")
	public void cuandoIngreseLosDatos(List<String> datos) {		
	    OnStage.theActorInTheSpotlight().attemptsTo(InteractuarAplicacion.deExcel(datos));
	}

	@Cuando("^cambie de lugar el archivo$")
	public void cambieDeLugarElArchivo(List<String> datos) {
	    OnStage.theActorInTheSpotlight().attemptsTo(GuardarArchivo.enLaRuta(datos));
	}

	@Entonces("^podra verificar el archivo$")
	public void podraVerificarElArchivo() {
	    
	}
}
