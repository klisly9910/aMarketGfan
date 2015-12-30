package com.testgfan;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ClickSplash extends UiAutomatorTestCase{
	public void testDemo2() throws UiObjectNotFoundException{
		getUiDevice().pressHome();
		UiScrollable uiScrollable = new UiScrollable(new UiSelector().scrollable(true));
		uiScrollable.setAsHorizontalList();
		uiScrollable.scrollForward();
		uiScrollable.scrollForward();
		
		UiObject uiObject = new UiObject(new UiSelector().text("机锋应用商店"));
		uiObject.clickAndWaitForNewWindow();
		uiObject.clickAndWaitForNewWindow();//直接点击闪屏
		
		
		
	}

}
