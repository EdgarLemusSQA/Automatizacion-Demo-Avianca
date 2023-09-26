package tasks;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import uis.NotePadUis;

public class EscribirTexto implements Task {

	private String texto;

	public EscribirTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.keyValues(Keys.chord(Keys.CONTROL, "a")).into(NotePadUis.TXT_TEXTO),
				Enter.theValue(texto).into(NotePadUis.TXT_TEXTO));
	}

	public static EscribirTexto enNotePad(String texto) {
		return Instrumented.instanceOf(EscribirTexto.class).withProperties(texto);
	}
}
