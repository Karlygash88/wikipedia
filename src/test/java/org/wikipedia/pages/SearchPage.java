package org.wikipedia.pages;

import org.wikipedia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement mainHeader;

    @FindBy(xpath = "//div[@class='fn']")
    public WebElement imageHeader;


}
