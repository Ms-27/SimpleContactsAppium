package org.eql;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContactsMainPage {
	
	private AndroidDriver<AndroidElement> driver;

	public ContactsMainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	MobileElement btn_allow;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/fragment_fab")
	MobileElement btn_add_contact;
}
