package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\amrutha.pothula\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\amrutha.pothula\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--log-level=3");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        try {

            driver.get("https://www.amazon.com/");

            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("iphone");

            searchBox.submit();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")));

            String resultText = firstResult.getText();
            if (resultText.contains("Apple iPhone")) {
                System.out.println("Test Passed: 'Apple iPhone' found in the first result.");
            } else {
                System.out.println("Test Failed: 'Apple iPhone' not found in the first result.");
            }
        } finally {

            driver.quit();
        }
    }
}

