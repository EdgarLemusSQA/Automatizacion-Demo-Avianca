package interactions;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class EsperaImplicita implements Interaction{

	@Override
	public <T extends Actor> void performAs(T actor) {
		BrowseTheWeb.as(actor).getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static Performable enPantalla() {
		return Instrumented.instanceOf(EsperaImplicita.class).withProperties();
	}
}
