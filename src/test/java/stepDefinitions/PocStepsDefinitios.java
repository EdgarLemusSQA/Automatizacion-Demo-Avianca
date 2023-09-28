package stepDefinitions;

import java.io.IOException;
import java.util.List;

import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import drivers.DriverWindows;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class PocStepsDefinitios {

	@Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }
	
	@Dado("^que el abre un archivo excel$")
	public void queElAbreUnArchivoExcel() {
		OnStage.theActorCalled("").can(BrowseTheWeb.with(DriverWindows.windowsHisDriver("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE").on()));
	}


	@Cuando("^cuando ingrese los datos$")
	public void cuandoIngreseLosDatos(List<String> datos) {
	    
	}

	@Cuando("^cambie de lugar el archivo$")
	public void cambieDeLugarElArchivo() {
	    
	}

	@Entonces("^podra verificar el archivo$")
	public void podraVerificarElArchivo() {
	    
	}
}
