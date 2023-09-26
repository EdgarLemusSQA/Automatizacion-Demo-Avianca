package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import uis.CalculadoraUis;

public class RealizarOperacion implements Task {

	private String operacion;

	public RealizarOperacion(String operacion) {
		this.operacion = operacion;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		for (int i = 0; i < operacion.length(); i++) {
			if (operacion.charAt(i) == '0') {
			    actor.attemptsTo(Click.on(CalculadoraUis.BTN_CERO));
			} else if (operacion.charAt(i) == '1') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_UNO));
			} else if (operacion.charAt(i) == '2') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_DOS));
			} else if (operacion.charAt(i) == '3') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_TRES));
			} else if (operacion.charAt(i) == '4') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_CUATRO));
			} else if (operacion.charAt(i) == '5') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_CINCO));
			} else if (operacion.charAt(i) == '6') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_SEIS));
			} else if (operacion.charAt(i) == '7') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_SIETE));
			} else if (operacion.charAt(i) == '8') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_OCHO));
			} else if (operacion.charAt(i) == '9') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_NUEVE));
			} else if (operacion.charAt(i) == '+') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_SUMA));
			} else if (operacion.charAt(i) == '-') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_RESTA));
			} else if (operacion.charAt(i) == '=') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_IGUAL));
			} else if (operacion.charAt(i) == '*') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_MULTIPLICACION));
			} else if (operacion.charAt(i) == '/') {
				actor.attemptsTo(Click.on(CalculadoraUis.BTN_DIVISION));
			}
		}

	}

	public static RealizarOperacion matematica(String operacion) {
		return Instrumented.instanceOf(RealizarOperacion.class).withProperties(operacion);
	}
}
