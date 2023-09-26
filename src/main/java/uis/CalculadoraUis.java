package uis;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class CalculadoraUis {

	public static final Target BTN_UNO = Target.the("").located(By.name("Uno"));
	public static final Target BTN_DOS = Target.the("").located(By.name("Dos"));
	public static final Target BTN_TRES = Target.the("").located(By.name("Tres"));
	public static final Target BTN_CUATRO = Target.the("").located(By.name("Cuatro"));
	public static final Target BTN_CINCO = Target.the("").located(By.name("Cinco"));
	public static final Target BTN_SEIS = Target.the("").located(By.name("Seis"));
	public static final Target BTN_SIETE = Target.the("").located(By.name("Siete"));
	public static final Target BTN_OCHO = Target.the("").located(By.name("Ocho"));
	public static final Target BTN_NUEVE = Target.the("").located(By.name("Nueve"));
	public static final Target BTN_CERO = Target.the("").located(By.name("Cero"));
	public static final Target BTN_IGUAL = Target.the("").located(By.name("Es igual a"));
	public static final Target BTN_SUMA = Target.the("").located(By.name("Más"));
	public static final Target BTN_RESTA = Target.the("").located(By.name("Menos"));
	public static final Target BTN_MULTIPLICACION = Target.the("").located(By.name("Multiplicar por"));
	public static final Target BTN_DIVISION = Target.the("").located(By.name("Dividido por"));
	public static final Target BTN_BORRAR = Target.the("").located(By.name("Borrar"));
	public static final Target TXT_RESULTADO = Target.the("").located(By.xpath("//*[contains(@AutomationId,'CalculatorResults')]"));
	
}
