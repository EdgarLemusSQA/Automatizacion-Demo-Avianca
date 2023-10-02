package uis;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class ExcelUis {
	
	public static final Target BTN_NEGRITA = Target.the("").located(By.name("Negrita"));
	public static final Target BTN_CURSIVA = Target.the("").located(By.name("Cursiva"));
	public static final Target BTN_RELLENO_COLOR = Target.the("").located(By.name("Color de relleno"));
	public static final Target BTN_LETRA_COLOR = Target.the("").located(By.xpath("//*[@AutomationId='FontColorPicker']"));
	public static final Target BTN_CREAR_LIBRO_EN_BLANCO = Target.the("").located(By.name("Libro en blanco"));
	public static final Target TXT_CELDA = Target.the("").located(By.name("Cuadro de nombres"));
	public static final Target TXT_TAMAÑO_FUENTE = Target.the("").located(By.className("NetUIComboboxAnchor"));
	public static final Target BTN_ARCHIVO = Target.the("").located(By.className("NetUIRibbonTab"));
	public static final Target BTN_GUARDAR = Target.the("").located(By.name("Guardar"));
	public static final Target BTN_EXAMINAR = Target.the("").located(By.name("Examinar"));
	public static final Target TXT_UBICACION = Target.the("").located(By.className("ToolbarWindow32"));
	public static final Target TXT_NOMBRE_ARCHIVO = Target.the("").located(By.className("AppControlHost"));

}
