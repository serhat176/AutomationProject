package StepDefinitions;


import Pages.BaseTest;
import Pages.FlightList;
import Pages.FlightForm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import io.cucumber.java.en.And;
import Hooks.Hooks;  // Hooks sınıfını import edin

public class SaatFiltrelemeSteps {
    FlightForm form = new FlightForm();


    //    @And("enuygun.com web sitesine git")
//    public void enterTheWebsite(){
//        form.setup();
//    }
    @And("Bilet tipini gidis-donus sec")
    public void selectTicketDirection(){
        form.clickRoundTripBtn();
    }
    @And("Kalkis yerine {string} yaz")
    public void selectFrom(String nereden) throws InterruptedException {
        form.setDepartureLocation(nereden);
    }
    @And("Varis yerine {string} yaz")
    public void selectDestination(String nereye) throws InterruptedException {
        form.setDestinationLocation(nereye);
    }
    @And("Ucuz bilet bul butonuna bas")
    public void clickFindFlight(){
        form.clickFindFlightBtn();
    }
    @And("Kalkis icin {string} tikla")
    public void clickOriginAirport(String airport){
        form.clickOriginAirport(airport);
    }
    @And("Varis icin {string} tikla")
    public void clickAirport(String airport){
        form.clickDestinationAirport(airport);;
    }
    @And("Gidis tarihini {string} sec")
    public void setDate(String date){
        form.setDepartureDate(date);
    }
    @And("Donus tarihini {string} sec")
    public void setReturnDate(String date){
        form.setReturnDate(date);
    }
    @And("Yetiskin sayisi {int} sec")
    public void setAdult(int number) throws InterruptedException {
        form.setAdultNumber(number);
    }
    @And("Cocuk sayisi {int} sec")
    public void setChild(int number) throws InterruptedException {
        form.setChildNumber(number);
    }
    @And("Bebek sayisi {int} sec")
    public void setBaby(int number) throws InterruptedException {
        form.setBabyNumber(number);
    }
    @And("Kisi sayacini ac")
    public void clickCounter() throws InterruptedException {
        form.clickNumberOfPassengers();
    }
    @And("Tipi {string} sec")
    public void selectClass(String classType){
        form.selectClass(classType);
    }
}
