package swaglabsapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	@FindBy(xpath = "//input[@id='user-name']")private WebElement untxt;
	@FindBy(xpath = "//input[@id='password']")private WebElement pwdtxt;
	@FindBy(xpath = "//input[@id='login-button']")private WebElement logbtn;
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getUntxt() {
		return untxt;
	}
	public WebElement getPwdtxt() {
		return pwdtxt;
	}
	public WebElement getLogbtn() {
		return logbtn;
	}
	//business library
	public void loginToApp(String un,String pwd) {
		untxt.sendKeys(un);
		pwdtxt.sendKeys(pwd);
		logbtn.click();
		
	}

}
