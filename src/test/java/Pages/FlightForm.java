package Pages;

import org.openqa.selenium.*;


public class FlightForm extends BaseTest {
    private By round_trip_btn = By.cssSelector("div[data-testid='search-round-trip-text']");
    private By departure_location = By.cssSelector("input[data-testid='endesign-flight-origin-autosuggestion-input']");
    private By destination_location = By.cssSelector("input[data-testid= 'endesign-flight-destination-autosuggestion-input']");
    private By airport_btn;
    private By departure_date_picker = By.cssSelector("input[data-testid='enuygun-homepage-flight-departureDate-datepicker-input']");
    private By return_date_picker = By.cssSelector("input[data-testid='enuygun-homepage-flight-returnDate-datepicker-input']");
    private By search_ticket_btn = By.cssSelector("button[data-testid='enuygun-homepage-flight-submitButton']");
    private By passenger_number_btn = By.cssSelector("input[data-testid='undefined-popover-button']");
    private By adult_btn = By.cssSelector("button[data-testid='flight-adult-counter-plus-button']");
    private By child_btn = By.cssSelector("button[data-testid='flight-child-counter-plus-button']");
    private By baby_btn = By.cssSelector("button[data-testid='flight-infant-counter-plus-button']");
    private By class_btn;

    public FlightForm() {
        this.driver = getDriver(); // Get the driver from BaseTest
    }

    public void setDepartureLocation(String departureLocation) throws InterruptedException {
        waitForElement(departure_location);
        driver.findElement(departure_location).sendKeys(departureLocation);
        Thread.sleep(2000); // Wait for 2 seconds
    }

    public void setDestinationLocation(String destinationLocation) throws InterruptedException {
        waitForElement(destination_location);
        driver.findElement(destination_location).sendKeys(destinationLocation);
        Thread.sleep(2000); // Wait for 2 seconds
    }

    public void clickFindFlightBtn() {
        driver.findElement(search_ticket_btn).click();
    }

    public void clickRoundTripBtn() {
        driver.findElement(round_trip_btn).click();
    }

    public void clickOriginAirport(String airport) {
        airport_btn = By.xpath("//button[contains(., '" + airport + "')]");
        waitForElement(airport_btn);
        driver.findElement(airport_btn).click();
    }

    public void clickDestinationAirport(String airport) {
        airport_btn = By.xpath("//button[contains(., '" + airport + "')]");
        waitForElement(airport_btn);
        driver.findElement(airport_btn).click();
    }

    public void setDepartureDate(String date) {
        By dateToSelect = By.cssSelector("button[title='" + date + "']");
        driver.findElement(departure_date_picker).click();
        waitForElement(dateToSelect);
        driver.findElement(dateToSelect).click();
    }

    public void setReturnDate(String date) {
        By dateToSelect = By.cssSelector("button[title='" + date + "']");
        driver.findElement(return_date_picker).click();
        waitForElement(dateToSelect);
        driver.findElement(dateToSelect).click();
    }

    public void setAdultNumber(int number) throws InterruptedException {
        waitForElement(adult_btn);
        for (int i = 0; i < number - 1; i++) {
            wait(1);
            driver.findElement(adult_btn).click();
        }
    }

    public void setChildNumber(int number) throws InterruptedException {
        waitForElement(child_btn);
        for (int i = 0; i < number; i++) {
            wait(1);
            driver.findElement(child_btn).click();
        }
    }

    public void setBabyNumber(int number) throws InterruptedException {
        waitForElement(baby_btn);
        for (int i = 0; i < number; i++) {
            wait(1);
            driver.findElement(baby_btn).click();
        }
    }

    public void clickNumberOfPassengers() {
        waitForElement(passenger_number_btn);
        driver.findElement(passenger_number_btn).click();
    }

    public void selectClass(String classType) {
        class_btn = By.cssSelector("button[data-testid='enuygun-homepage-flight-" + classType.toLowerCase() + "Cabin']");
        waitForElement(class_btn);
        driver.findElement(class_btn).click();
    }
}
