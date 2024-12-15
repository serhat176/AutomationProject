package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class FlightList extends BaseTest {
    By filterPanel = By.cssSelector("div.flight-list-body");
    By departureArrivalTimeFilter = By.cssSelector("i.ctx-filter-departure-return-time.ei-expand-more");
    By airlineFilter = By.cssSelector("i[class='ctx-filter-airline ei-expand-more ']");
    By firstFlightButton = By.id("flight-0");
    By superEcoPanel = By.cssSelector("div[data-testid='departureProviderPackageItemSüper Eko']");
    By returnSuperEcoPanel = By.cssSelector("div[data-testid='returnProviderPackageItemSüper Eko']");
    By selectContinueButton = By.cssSelector("button[data-testid='providerSelectBtn']");
    By proceedCheckoutButton = By.id("continue-button");

    public void waitForList() {
        waitForElement(filterPanel);
    }

    public void setDepartureArrivalTimeFilter() throws InterruptedException {
        driver.findElement(departureArrivalTimeFilter).click();
        wait(3);

        try {
            WebElement sliderStart = driver.findElement(By.cssSelector(".rc-slider-handle-1"));
            WebElement sliderEnd = driver.findElement(By.cssSelector(".rc-slider-handle-2"));
            Actions actions = new Actions(driver);
            actions.clickAndHold(sliderStart)
                    .moveByOffset(100, 0)
                    .release()
                    .perform();
            Thread.sleep(2000);
            actions.clickAndHold(sliderEnd)
                    .moveByOffset(-60, 0)
                    .release()
                    .perform();
            System.out.println("Slider successfully set!");
            wait(5);
            By flightList = By.cssSelector(".flight-item");
            waitForElement(flightList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkDepartureHours() {
        List<WebElement> flightList = driver.findElements(By.cssSelector(".flight-item"));
        LocalTime start = LocalTime.parse("10:00");
        LocalTime end = LocalTime.parse("18:00");
        for (WebElement flight : flightList) {
            LocalTime departureTime = LocalTime.parse(flight.findElement(By.cssSelector(".flight-departure-time")).getText());
            if (start.isAfter(departureTime)) {
                Assert.fail();
                System.out.println(start + " " + end);
            } else if (end.isBefore(departureTime)) {
                Assert.fail();
            }
        }
        Assert.assertTrue(true);
    }

    public void clickAirlineFilter(String airlineName) {
        waitForElement(airlineFilter);
        driver.findElement(airlineFilter).click();
        By airlineElement = By.xpath("//span[text()='" + airlineName + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(airlineElement));
        driver.findElement(airlineElement).click();
    }

    public void checkPricesIncreased(String airline) {
        List<WebElement> flightList = driver.findElements(By.cssSelector(".flight-item"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        int tmpPrice = 0;
        for (WebElement flight : flightList) {
            try {
                WebElement priceElement = flight.findElement(By.cssSelector(".summary-average-price"));
                String priceText = priceElement.getText().replace(".", "").replace(" TL", "").trim();
                String airlineName = flight.findElement(By.cssSelector(".summary-marketing-airlines")).getText();
                int price = Integer.parseInt(priceText);
                System.out.println(tmpPrice + " " + price);
                if (price < tmpPrice) {
                    System.out.println(airlineName + " " + airline);
                    Assert.fail("Price order is broken: " + price + " < " + tmpPrice);
                } else if (!airlineName.equals(airline)) {
                    Assert.fail("Unexpected airline: " + "Actual: " + airlineName + " Expected: " + airline);
                }
                tmpPrice = price;
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element encountered, retrying...");
                flightList = driver.findElements(By.cssSelector(".flight-item"));
            }
        }
        Assert.assertTrue(true);
    }

    public void clickFirstFlight() {
        waitForElement(firstFlightButton);
        driver.findElement(firstFlightButton).click();
    }

    public void selectSuperEco() {
        waitForElement(superEcoPanel);
        driver.findElement(superEcoPanel).click();
    }

    public void selectReturnFlight() {
        try {
            WebElement secondList = driver.findElements(By.className("flight-list-body")).get(1);
            WebElement firstItemSecondList = secondList.findElement(By.className("flight-item"));
            WebElement selectButton = firstItemSecondList.findElement(By.className("action-select-btn"));
            selectButton.click();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void selectSuperEcoReturn() {
        waitForElement(returnSuperEcoPanel);
        driver.findElement(returnSuperEcoPanel).click();
    }

    public void clickSelect() {
        waitForElement(selectContinueButton);
        driver.findElement(selectContinueButton).click();
    }

    public void waitProceedCheckout() {
        waitForElement(proceedCheckoutButton);
        boolean isButtonPresent = driver.findElements(proceedCheckoutButton).size() > 0;
        Assert.assertTrue(isButtonPresent);
    }
}
