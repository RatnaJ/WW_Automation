package com.ww.pages;

import com.ww.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindMeeting extends BasePage{

    @FindBy(css="#meetingSearch")
    WebElement meetingSearch;

    @FindBy(css=".input-group-btn")
    WebElement searchButton;

    @FindBy(css="div.meeting-location .location__name span")
    List<WebElement> locNames;

    @FindBy(css="div.meeting-location .location__distance")
    List<WebElement> distance;

    @FindBy(css=".location__container")
    List<WebElement> locations;

    public FindMeeting(){
        PageFactory.initElements(driver, this);
    }

    /**
     * gets the title of the Find Meeting page
     * @return
     */
    public String verifyTitle(){
        String title = driver.getTitle();
        return title;
    }

    /**
     * Search for the locations
     * @param locName
     * @return
     */
    public FindMeeting searchLocation(String locName){
        meetingSearch.sendKeys(locName);
        searchButton.click();
        return this;
    }


    /**
     * gets the name of the first location in the search list
     * @return
     */
    public String getFirstLocation(){

        String firstLocName = locations.get(0).findElement(By.cssSelector(".location__name span")).getText();
        return firstLocName;
    }

    /**
     * gets the distance of the first location in the search results list
     * @return
     */
    public String getFirstLocationDistance(){

        String firstLocDistance = locations.get(0).findElement(By.cssSelector(".location__distance")).getText();
        return firstLocDistance;

    }

    /**
     * Clicking on the first location name, navigates to the Location page
     * @return
     */
    public LocationPage GoToFistLoc(){

        locations.get(0).findElement(By.cssSelector(".location__name span")).click();
        return new LocationPage();
    }




}
