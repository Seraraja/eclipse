package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id="email")
	private WebElement txtUsername;
	
	@CacheLookup
	@FindBys({@FindBy(id="pass"),@FindBy(xpath="//input[@type='password']")})
	private WebElement txtPassword;
	
	@FindAll({@FindBy(name="login"),@FindBy(xpath="login")})
	private WebElement btnLogin;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
}
