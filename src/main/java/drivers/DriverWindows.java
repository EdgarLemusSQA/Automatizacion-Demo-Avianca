package drivers;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;

public class DriverWindows {

	public static WindowsDriver<WebElement> windowsSession = null;
	
	public static DriverWindows windowsHisDriver(String path) {
		try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", path);
            capabilities.setCapability("platformName", "Windows");
            windowsSession = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), capabilities);
            windowsSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
		
		return new DriverWindows();
	}
	
	public WindowsDriver<WebElement> on(){
		return windowsSession;
	}
}
