package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import drivers.DriverWindows;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.EscribirTexto;
import uis.NotePadUis;

public class NotePadStepsDefinitions {

	@Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }
	
	@Dado("^que el usuario se encuentra en Notepad\\+\\+ de windows$")
	public void queElUsuarioSeEncuentraEnNotepadDeWindows() {
		 OnStage.theActorCalled("").can(BrowseTheWeb.with(DriverWindows.windowsHisDriver("C:\\Program Files\\Notepad++\\notepad++.exe").on()));
	}


	@Cuando("^cuando escriba el texto (.*) en la aplicacion$")
	public void cuandoEscribaElTextoEsteEsUnTextoParaNotePadEnLaAplicacion(String texto) {
	    OnStage.theActorInTheSpotlight().attemptsTo(EscribirTexto.enNotePad(texto));
	}

	@Entonces("^podra verificar el texto (.*) en pantalla$")
	public void podraVerificarElTextoEsteEsUnTextoParaNotePadEnPantalla(String texto) {
	    OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(NotePadUis.TXT_TEXTO), WebElementStateMatchers.containsText(texto)));
	}
}
