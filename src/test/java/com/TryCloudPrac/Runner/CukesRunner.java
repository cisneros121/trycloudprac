package com.TryCloudPrac.Runner;

import com.google.common.base.Verify;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html"
                , "rerun:target/failedTest.txt"}, // target file comes up even if i change name cucumber-report is file name
        features = "src/test/resources/features",
        glue = "com/TryCloudPrac/StepDefinitions",
        dryRun = true, publish = true, tags = "@wip"


)
public class CukesRunner {



}
