package com.automation.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
                features ="classpath:feature"
                ,glue={"com.automation.api.stepdef"},
                plugin={"html:target/cucumber-html-report.html"}

)

public class TestRunner {

}