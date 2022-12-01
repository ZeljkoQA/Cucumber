package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class ScreenshotClass extends BasePage {

    public ScreenshotClass(WebDriver d) {
        super(d);
    }

    public void takeScreenshot(Scenario scenario) {

        if (driver != null) {

            //Koristimo datum da damo jedinstveno ime screenshotu.
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

            //Uzima screenshot sa Selenijumom, cuva ga privremeno u scrFile i potom kopira u destFile
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("lib\\errorScreenshots\\" + scenario.getName() + "_"
                    + formater.format(calendar.getTime()) + "-" + Arrays.toString(scenario.getSourceTagNames().toArray()) + ".jpg");

            try {
                FileUtils.copyFile(scrFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else System.out.println("Screenshot failed due to driver lost in parallel execution");
    }

}