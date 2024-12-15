package StepDefinitions;

import Pages.BaseTest;
import io.cucumber.java.en.And;

public class BaseTestSteps {

    BaseTest test = new BaseTest();
    @And("{int} saniye bekle")
    public void wait(int seconds) throws InterruptedException {
        test.wait(seconds);
    }

}
