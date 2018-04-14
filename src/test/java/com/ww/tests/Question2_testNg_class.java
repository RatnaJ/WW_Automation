package com.ww.tests;

import com.ww.base.BasePage;
import com.ww.pages.FindMeeting;
import com.ww.pages.HomePage;
import com.ww.pages.LocationPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Question2_testNg_class extends BasePage {

    HomePage homePage;
    FindMeeting findMeeting;
    LocationPage locationPage;

    @BeforeClass
    public void setUp() {
        initialization("chrome", "https://www.weightwatchers.com/us/");
        homePage = new HomePage();
    }

    @Test(priority = 1, description="Verify homepage title")
    public void homePageTitleTest() {

        String title = homePage.verifyTitle();
        Assert.assertEquals(title, "Weight Loss Program, Recipes & Help | Weight Watchers");

    }

    @Test(priority = 2, description = "Verify find meeting page title")
    public void goFindMeetingTest() {
        findMeeting = homePage.findMeeting();
        String title1 = findMeeting.verifyTitle();
        Assert.assertEquals(title1, "Find A Meeting: Get Schedules & Times Near You | Weight Watchers");

    }

    @Test(priority = 3, description = "Print the first location Name/ Distance")
    public void printFirstLocDetails(){
        findMeeting.searchLocation("10011");
        System.out.println("First Location Name: "+findMeeting.getFirstLocation());
        System.out.println("First Location Distance: "+findMeeting.getFirstLocationDistance());
    }


    @Test(priority = 4, description = "Verify current location name with name of the first searched result")
    public void verifyFirstLocation(){
        locationPage = findMeeting.GoToFistLoc();
        Assert.assertEquals(locationPage.getLocName(), findMeeting.getFirstLocation());
    }

    @Test(priority = 5, description = "Display hours of operation")
    public void displayTimings(){

        locationPage.displayTimings();

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
