package com.TryCloudPrac.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html"
                , "rerun:target/failedTest.txt"}, // target file comes up even if i change name cucumber-report is file name
        features = "src/test/resources/features",
        glue = "com/TryCloudPrac/StepDefinitions",
        dryRun = false, publish = true, tags = "@wip"


)
public class CukesRunner {


}
