package com.qaprosoft.carina.demo.utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


public class TabHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * Open any other page if present
     *
     * @param driver
     */
    public static void switchBetweenPages(WebDriver driver) {
        LOGGER.info("Switch page");
        if ((long) driver.getWindowHandles().size() == 1) {
            openAvailablePage(driver);
            return;
        }

        for (String windowHandle : driver.getWindowHandles()) {
            if (!driver.getWindowHandle().contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void closeCurrentPage(WebDriver driver) {
        LOGGER.info("Close current page");
        driver.close();
    }

    private static void openAvailablePage(WebDriver driver) {
        LOGGER.info("Open available page");
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }
}
