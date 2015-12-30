package com.testgfan;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class FirstOpenGfan extends UiAutomatorTestCase{
	public void testDemo() throws  UiObjectNotFoundException{
		getUiDevice().pressHome();
		//滚动屏幕，一个方法只滚动一屏
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		appViews.scrollForward();
		appViews.scrollForward();
		
		//点击“机锋应用商店”
		UiObject gfan = new UiObject(new UiSelector().index(13));
		gfan.clickAndWaitForNewWindow();
		
		//滑动引导页
		UiScrollable uiScrollable = new UiScrollable(new UiSelector().scrollable(true));
		uiScrollable.setAsHorizontalList();
		uiScrollable.scrollForward();
		uiScrollable.scrollForward();
		
		//点击“立即体验”进入首页
		UiObject tiyan = new UiObject(new UiSelector().text("机锋应用商店"));
		tiyan.clickAndWaitForNewWindow();
		
		UiSelector uiSelector = new UiSelector();
		UiSelector s = uiSelector.resourceId("com.mappn.gfan:id/banner_item_imageview");
		if(s == null){
			UiObject  netWork = new UiObject(new UiSelector().resourceId("com.mappn.gfan:id/btn_no_network"));
			netWork.clickAndWaitForNewWindow();
		}else{
			UiObject banner = new UiObject(new UiSelector().resourceId("com.mappn.gfan:id/banner_item_imageview"));
			banner.clickAndWaitForNewWindow();
			
		}
		
	}
	
}