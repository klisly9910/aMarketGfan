package com.txh.uitestgfan;

import junit.framework.Assert;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

	public class UiTestGfan extends UiAutomatorTestCase{

	/**
	 * 执行方法
	 * @param 机锋应用商店uitest
	 */
	public void testSearchDefaultText() throws UiObjectNotFoundException{
		//openGfan();
		//jumpSplash();
		//excuteTestSearchDefaultTex();
		//clickSearchTextV();
		//inPutWord();
		//openMyPage();
		//clickUserImage();
		//userLogin();
		//userLogout();
		blankUsernPw();
		
	}	
	
	/**
	 * 打开机锋应用商店
	 * @throws UiObjectNotFoundException
	 */
	public void openGfan() throws UiObjectNotFoundException{
		getUiDevice().pressHome();
		/*UiScrollable uiScrollable = new UiScrollable(new UiSelector().scrollable(true));
		uiScrollable.setAsHorizontalList();
		uiScrollable.scrollForward();*/
		//点击机锋应用商店
		UiObject logo = new UiObject(new UiSelector().index(7));
		logo.clickAndWaitForNewWindow();	
	}

	/**
	 * 点击跳过闪屏,点击跳过闪屏进入机锋市场首页
	 * @throws UiObjectNotFoundException
	 */
	public void jumpSplash() throws UiObjectNotFoundException{
		UiObject splash = new UiObject(new UiSelector().resourceId("com.mappn.gfan:id/ib_jump_advert"));
		if(splash.exists()){
			splash.clickAndWaitForNewWindow();
		}else{
			return;
		}
	}
	
	/**
	 * 获取默认搜索关键字并判断与预期结果是否一致
	 * @throws UiObjectNotFoundException
	 */
	public void excuteTestSearchDefaultTex() throws UiObjectNotFoundException{
		UiSelector textView = new UiSelector();
		textView.index(3);
		UiObject search = new UiObject(textView);
		String text = search.getText();
		Assert.assertEquals("",text);
		}
	/**
	 * 点击搜索框
	 * @throws UiObjectNotFoundException
	 */
	public void clickSearchTextV() throws UiObjectNotFoundException{
		UiObject textV = new UiObject(new UiSelector()
						.resourceId("com.mappn.gfan:id/tv_search"));
		textV.click();
		
	}
	/**
	 * 点击搜索框后，输入搜索关键词进行搜索
	 * @throws UiObjectNotFoundException
	 */
	public void inPutWord() throws UiObjectNotFoundException{
		UiObject textVChild = new UiObject(new UiSelector()
							.resourceId("com.mappn.gfan:id/top_main_rl"));
		textVChild.setText("QQ");
		UiObject selectTextV = new UiObject(new UiSelector()
							.resourceId("com.mappn.gfan:id/rl_top_container"));
		if(selectTextV.exists()){
			selectTextV.clickAndWaitForNewWindow();
		}else{
			UiObject selectButton = new UiObject(new UiSelector()
						.resourceId("com.mappn.gfan:id/top_search_container"));
			selectButton.clickAndWaitForNewWindow();
		}
	}
	/**
	 * 打开个人中心
	 * @throws UiObjectNotFoundException
	 */
	public void openMyPage() throws UiObjectNotFoundException{
		UiObject my = new UiObject(new UiSelector().text("我的"));
		my.click();
		
	}
	public void clickUserImage() throws UiObjectNotFoundException{
		UiObject userLogin = new UiObject(new UiSelector()
						.resourceId("com.mappn.gfan:id/iv_user_head"));
		userLogin.click();
		
	}
	/**
	 * 输入正确的用户名、密码点击登录
	 * @throws UiObjectNotFoundException
	 */
	public void userLogin() throws UiObjectNotFoundException{
		UiObject userName = new UiObject(new UiSelector()
							.resourceId("com.mappn.gfan:id/et_gfan"));
		userName.setText("imopan88");
		UiObject password = new UiObject(new UiSelector()
							.resourceId("com.mappn.gfan:id/et_password"));
		password.setText("654321");
		UiObject login = new UiObject(new UiSelector()
						.resourceId("com.mappn.gfan:id/rl_login"));
		login.clickAndWaitForNewWindow();
		UiObject afterLogin = new UiObject(new UiSelector().resourceId("com.mappn.gfan:id/tv_user_name"));
		afterLogin.waitForExists(1000);
		Assert.assertEquals(false, afterLogin.exists());	
	}
	/**
	 * 输入空的用户名、空的密码，直接点击登录
	 * @throws UiObjectNotFoundException
	 */
	public void blankUsernPw() throws UiObjectNotFoundException{
		UiObject blankUser = new UiObject(new UiSelector()
						.resourceId("com.mappn.gfan:id/et_gfan"));
		blankUser.setText(" ");
		UiObject blankPw = new UiObject(new UiSelector()
						.resourceId("com.mappn.gfan:id/et_password"));
		blankPw.setText(" ");
		UiObject clicklogin = new UiObject(new UiSelector()
						.resourceId("com.mappn.gfan:id/rl_login"));
		clicklogin.clickAndWaitForNewWindow(2000);
		UiObject waitMesg = new UiObject(new UiSelector().resourceId("android:id/message"));
		Assert.assertEquals(true, waitMesg.exists());
		
	}
	public void userLogout() throws UiObjectNotFoundException{
		UiObject userHead = new UiObject(new UiSelector()
							.resourceId("com.mappn.gfan:id/iv_user_head"));
		userHead.click();
		UiObject logout = new UiObject(new UiSelector()
							.className("android.widget.TextView").text("注销"));
		logout.click();
		UiObject cancle = new UiObject(new UiSelector()
						.resourceId("com.mappn.gfan:id/button_left"));
		cancle.click();
		
		
	}

}
