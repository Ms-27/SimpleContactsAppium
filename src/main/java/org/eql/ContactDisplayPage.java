package org.eql;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContactDisplayPage {
	
	@SuppressWarnings("unused")
	private AndroidDriver<AndroidElement> driver;

	public ContactDisplayPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_first_name")
	MobileElement field_first_name;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_surname")
	MobileElement field_surname;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_number")
	MobileElement field_number;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_email")
	MobileElement field_email;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"More options\"]")
	MobileElement btn_3dots;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView\r\n")
	MobileElement btn_delete;
	
}