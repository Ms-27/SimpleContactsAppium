package org.eql;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorTest {

	private AndroidDriver<AndroidElement> driver;
	
	@Before
	public void setup() throws MalformedURLException {
		//Définition des Desired Capabilities
		DesiredCapabilities desired_capabilities = new DesiredCapabilities();
		desired_capabilities.setCapability("platformName", "Android");
		desired_capabilities.setCapability("platformVersion", "8.1.0");
		desired_capabilities.setCapability("deviceName", "Android Emulator");
		desired_capabilities.setCapability("appPackage", "com.android.calculator2");
		desired_capabilities.setCapability("appActivity", ".Calculator");

		//Définition de l'url du server utilisé
		URL url = new URL("http://localhost:4723/wd/hub");

		//Instanciatio du driver
		driver = new AndroidDriver<AndroidElement>(url, desired_capabilities);
	}
	
	@Test
	public void test() {
		//instanciation de la page de l'application
		Calculator calculator = new Calculator(driver);
		
		//On appuye successivement sur les touches: 4, x, 3 et =
		calculator.btn_4.click();
		calculator.btn_multiply.click();
		calculator.btn_3.click();
		calculator.btn_equal.click();
		
		//vérification du résultat
		assertEquals("12", calculator.value_result.getText());
	}

}
