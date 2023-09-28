package uis;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class ExcelUis {
	
	public static final Target BTN_MAXIMIZAR = Target.the("").located(By.name("Maximizar"));
	public static final Target BTN_CREAR_LIBRO_EN_BLANCO = Target.the("").located(By.name("Libro en blanco"));

}
