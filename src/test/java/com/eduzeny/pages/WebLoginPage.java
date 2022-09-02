package com.eduzeny.pages;

import com.eduzeny.utilities.ConfigurationReader;
import com.eduzeny.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.ObjectInputFilter;

public class WebLoginPage {
    public WebLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwrd;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginBtn;

    public void login(){
        userName.sendKeys(ConfigurationReader.getProperty("web.app.username"));
        passwrd.sendKeys(ConfigurationReader.getProperty("web.app.password"));
        loginBtn.click();

    }
}
