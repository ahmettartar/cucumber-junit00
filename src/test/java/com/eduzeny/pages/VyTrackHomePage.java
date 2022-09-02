package com.eduzeny.pages;

import com.eduzeny.utilities.Driver;
import com.eduzeny.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VyTrackHomePage {

    public VyTrackHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title title-level-1']")
    public List<WebElement> allModules;

    @FindBy(css = "#user-menu>a") //xpath //li[@id='user-menu']/a
    public WebElement username;

}
