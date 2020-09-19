package org.eql;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SimpleContactsTest {
	
private AndroidDriver<AndroidElement> driver;
	//JDD
	String prenom = "Bob";
	String nom = "Test";
	String num_tel = "+33699887766";
	String email = "bob@test.com";
	
	@Before
	public void setup() throws MalformedURLException {
		//Définition des Desired Capabilities
		DesiredCapabilities desired_capabilities = new DesiredCapabilities();
		desired_capabilities.setCapability("platformName", "Android");
		desired_capabilities.setCapability("platformVersion", "8.1.0");
		desired_capabilities.setCapability("deviceName", "Android Emulator");
		desired_capabilities.setCapability("appPackage", "com.simplemobiletools.contacts");
		desired_capabilities.setCapability("appActivity", "com.simplemobiletools.contacts.activities.MainActivity");

		//Définition de l'url du server utilisé
		URL url= new URL("http://localhost:4723/wd/hub");

		//Instanciatio du driver
		driver = new AndroidDriver<AndroidElement>(url, desired_capabilities);
	}
	
	@After
	public void teardown() {
		//Suppression du contact avant de quitter le driver
		ContactDisplayPage page_contact = new ContactDisplayPage(driver);
		page_contact.btn_3dots.click();
		page_contact.btn_delete.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void testAddContact() {
		//Gestion des deux alertes aux démarrage
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		
		//Instanciation de la page main puis click sur le bouton add contact
		ContactsMainPage page_principale = new ContactsMainPage(driver);
		page_principale.btn_add_contact.click();
		NewContactPage page_nouveau_contact = new NewContactPage(driver);
		
		//Renseignement des champs puis validation
		page_nouveau_contact.input_first_name.sendKeys(prenom);
		page_nouveau_contact.input_surname.sendKeys(nom);
		page_nouveau_contact.input_number.sendKeys(num_tel);
		page_nouveau_contact.input_email.sendKeys(email);
		
		assertEquals(prenom, page_nouveau_contact.input_first_name.getText());
		assertEquals(nom, page_nouveau_contact.input_surname.getText());
		assertEquals(num_tel, page_nouveau_contact.input_number.getText());
		assertEquals(email, page_nouveau_contact.input_email.getText());
		
		page_nouveau_contact.btn_save.click();
		
		//Consultation de la fiche du nouveau contact
		ContactsMainPage page_principale2 = new ContactsMainPage(driver);
		page_principale2.elt_contact.click();
		ContactDisplayPage page_contact = new ContactDisplayPage(driver);
		
		assertEquals(prenom, page_contact.field_first_name.getText());
		assertEquals(nom, page_contact.field_surname.getText());
		assertEquals(num_tel, page_contact.field_number.getText());
		assertEquals(email, page_contact.field_email.getText());
		
	}

}
