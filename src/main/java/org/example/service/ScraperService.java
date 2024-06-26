package org.example.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ScraperService {

    public static final String URL = "https://app.rtd-denver.com/route/E/alerts";

    public List<WebElement> scrape(ChromeDriver driver){
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        final List<WebElement> alerts = driver.findElements(By.className("RouteRiderAlerts___StyledDiv3-sc-13vycjo-4"));
        final List<WebElement> alertList = alerts.getFirst().findElements(By.tagName("li"));
        return alertList;
    }
}
