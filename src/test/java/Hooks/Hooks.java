package Hooks;

import Pages.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import  Runner.Runner_General;



public class Hooks extends BaseTest {

    @Before
    public void beforeScenario(Scenario scenario) {
        setup(); // BaseTest'teki setup() metodu çağrılıyor
    }

    @After
    public void afterScenario(Scenario scenario) {

        tearDown(); // BaseTest'teki tearDown() metodu çağrılıyor
    }

}
