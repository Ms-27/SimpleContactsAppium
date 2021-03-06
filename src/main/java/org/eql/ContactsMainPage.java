package org.eql;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContactsMainPage {
	
	@SuppressWarnings("unused")
	private AndroidDriver<AndroidElement> driver;

	public ContactsMainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/fragment_fab")
	MobileElement btn_add_contact;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_name")
	MobileElement elt_contact;
}