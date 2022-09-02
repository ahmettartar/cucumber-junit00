package com.eduzeny.pages;

import com.eduzeny.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebAllOrderPage {
    public WebAllOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//tbody//tr[1]//td[1]")
    public WebElement firstRowname;
}
