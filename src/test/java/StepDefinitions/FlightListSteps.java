package StepDefinitions;

import Pages.FlightList;
import io.cucumber.java.en.And;

public class FlightListSteps {

    FlightList list = new FlightList();

    @And("Liste sayfasinin geldigi gor")
    public void waitListPage(){
        list.waitForList();
    }
    @And("Gidis kalkis varis saatlerini ayarla")
    public void setDepartureHour() throws InterruptedException {
        list.setDepartureArrivalTimeFilter();
    }
    @And("Listelenen ucuslarin gidis ve kalkis saatlerinin dogru geldigini kontrol et")
    public void checkDepartureHours(){
        list.checkDepartureHours();
    }
    @And("{string} sec")
    public void choseThy(String airlineName){
        list.clickAirlineFilter(airlineName);
    }
    @And("Fiyatlarin arttigini ve {string} oldugunu kontrol et")
    public void checkPrices(String airline){
        list.checkPricesIncreased(airline);

    }
    @And("Ilk ucusu sec")
    public void selectFirstFlight(){
        list.clickFirstFlight();
    }
    @And("Super Eco sec")
    public void selectSuperEco(){
        list.selectSuperEco();
    }
    @And("Ilk donus ucagini sec")
    public void selectFirstFlightForReturn(){
        list.selectReturnFlight();
    }
    @And("Donus icin Super Eco sec")
    public void selectSuperEcoForReturn(){
        list.selectSuperEcoReturn();
    }
    @And("Sec ve ilerle butonuna bas")
    public void selectAndContinue(){
        list.clickSelect();
    }
    @And("Odemeye ilerle butonunu bekle")
    public void proceedCheckout(){
        list.waitProceedCheckout();
    }
}
