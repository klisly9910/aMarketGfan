package com.testgfan;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class JumpSplash extends UiAutomatorTestCase{
	public void testDemo2() throws UiObjectNotFoundException{
		getUiDevice().pressHome();
		UiScrollable uiScrollable = new UiScrollable(new UiSelector().scrollable(true));
		uiScrollable.setAsHorizontalList();
		uiScrollable.scrollForward();
		uiScrollable.scrollForward();
		
		//点击机锋应用商店
		UiObject uiObject = new UiObject(new UiSelector().text("机锋应用商店"));
		uiObject.clickAndWaitForNewWindow();
		
		//点击跳过闪屏
		UiObject splash = new UiObject(new UiSelector().resourceId("com.mappn.gfan:id/ib_jump_advert"));
		splash.clickAndWaitForNewWindow();//点击跳过闪屏进入机锋市场首页
		
		//侧拉菜单，点击加速
		UiObject homeMenu = new UiObject(new UiSelector().resourceId("com.mappn.gfan:id/home_menu"));
		homeMenu.click();
		UiObject speed = new UiObject(new UiSelector().resourceId("com.mappn.gfan:id/sv_go_speed"));
		speed.clickAndWaitForNewWindow();
		//进入设置页面，点击某个复选框
		UiObject setObj = new UiObject(new UiSelector().resourceId("com.mappn.gfan:id/text1"));
		setObj.click();
		UiObject afterInstall = new UiObject(new UiSelector()
								.className("android.widget.RelativeLayout").instance(5)
								.childSelector(new UiSelector().resourceId("android:id/checkbox")));
		afterInstall.clickBottomRight();
		
		//检查更新
		UiObject update = new UiObject(new UiSelector().className("android.widget.RelativeLayout")
							.childSelector(new UiSelector().resourceId("com.mappn.gfan:id/tv_name")));
		update.clickAndWaitForNewWindow(21000);
		
		//检查版本号
		UiSelector uis = new UiSelector();
		UiSelector u = uis.text("版本2.1.1");
		if(u.equals(u)){
			System.out.println("correct");
			
		}
	
		
		
		
		
		
		
		
		
	}
}


