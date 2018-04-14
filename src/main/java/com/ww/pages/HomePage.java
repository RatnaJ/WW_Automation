package com.ww.pages;

import com.ww.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'header-desktop')]//a[contains(text(), 'Find a Meeting ')]")
    WebElement findMeeting;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    /**
     * gets the title of home page
     * @return
     */
    public String verifyTitle(){
        String title = driver.getTitle();
        return title;
    }

    /**
     * Navigates to the find meeting page
     * @return
     */
    public FindMeeting findMeeting(){
        findMeeting.click();
        return new FindMeeting();
    }


}
