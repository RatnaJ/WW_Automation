package com.ww.pages;

import com.ww.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class LocationPage extends BasePage {

    Map<String, String> map = new LinkedHashMap<String, String>();

    @FindBy(css = ".location__name span")
    WebElement locName;

    @FindBy(css = "ul.hours-list .hours-list-item-wrapper")
    List<WebElement> timeList;

    @FindBy(css = "ul.hours-list .hours-list-item-wrapper .hours-list-item-day")
    List<WebElement> daysList;

    @FindBy(css = "ul.hours-list .hours-list-item-wrapper .hours-list-item-hours")
    List<WebElement> hoursList;


    public LocationPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * gets the location name from the Locations page
     * @return
     */
    public String getLocName() {
        String loc = locName.getText();
        return loc;
    }

    /**
     * Displays the timings for the selected location
     *
     * Approach followed:
     * 1. Stored Hours of operations of all 7 days in list (List of WebElements)
     * 2. Loop through the above list -> each iteration, get the day and hours of operation in and add them to the Map object.
     * 3. finally, list the values from the Map
     *
     */
    public void displayTimings() {
        String day = null;
        String timings = null;

        for (WebElement time : timeList
                ) {
            day = time.findElement(By.cssSelector(".hours-list-item-day")).getText();
            List<WebElement> hoursList = time.findElements(By.cssSelector(".hours-list-item-hours"));
            for (WebElement hour : hoursList
                    ) {
                timings = "\n" + hour.getText() + "\n";
            }

            map.put(day, timings);

        }

        Set<String> keys = map.keySet();
        System.out.println("\n" + "Hours Of Operation" + "\n");
        for (String key : keys
                ) {
            System.out.println(key + "      " + map.get(key));
        }
    }
}
