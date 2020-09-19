package org.eql;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Calculator {
	
	private AndroidDriver<AndroidElement> driver;

	public Calculator(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.android.calculator2:id/digit_3")
	MobileElement btn_3;
	
	@AndroidFindBy(id="com.android.calculator2:id/digit_4")
	MobileElement btn_4;
	
	@AndroidFindBy(id="com.android.calculator2:id/op_mul")
	MobileElement btn_multiply;
	
	@AndroidFindBy(id="com.android.calculator2:id/eq")
	MobileElement btn_equal;
	
	@AndroidFindBy(id="com.android.calculator2:id/result")
	MobileElement value_result;
}