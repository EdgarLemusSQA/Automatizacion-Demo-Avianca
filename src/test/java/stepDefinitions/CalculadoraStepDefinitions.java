package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import drivers.DriverWindows;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.RealizarOperacion;
import uis.CalculadoraUis;

public class CalculadoraStepDefinitions {

	@Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }
	
	@Dado("^que el usuario se encuentra en la calculadora de windows$")
	public void queElUsuarioSeEncuentraEnLaCalculadoraDeWindows() {
	    OnStage.theActorCalled("").can(BrowseTheWeb.with(DriverWindows.windowsHisDriver("Microsoft.WindowsCalculator_8wekyb3d8bbwe!App").on()));
	}


	@Cuando("^cuando realice la operacion (.*)$")
	public void cuandoRealiceLaOperacion(String operacion) {
	    OnStage.theActorInTheSpotlight().attemptsTo(RealizarOperacion.matematica(operacion.replace(" ", "")));
	}

	@Entonces("^podra verificar como resultado el valor (.*) en pantalla$")
	public void podraVerificarComoResultadoElValorEnPantalla(String resultado) {
	    OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(CalculadoraUis.TXT_RESULTADO), WebElementStateMatchers.containsText(resultado)));
	}
	
	@After
	public void after() {
		if (DriverWindows.windowsSession != null) {
	        DriverWindows.windowsSession.quit();
	    }
	}
}
