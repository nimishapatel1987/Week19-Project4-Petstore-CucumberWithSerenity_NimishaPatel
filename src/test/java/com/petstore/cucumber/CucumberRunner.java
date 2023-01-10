package com.petstore.cucumber;

import com.petstore.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/java/resources/feature")
@RunWith(CucumberWithSerenity.class)
public class CucumberRunner extends TestBase {
}
