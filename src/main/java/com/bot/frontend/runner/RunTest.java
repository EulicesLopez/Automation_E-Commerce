package com.bot.frontend.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src//main//resources//features"},
        glue = {
                "com.bot.frontend.Steps",
                "com.bot.frontend.helpers"
        },
        plugin = {"pretty", "html:target/cucumber"},
        tags = {"@Shopping"},
        strict = false,
        monochrome = false
)


@Test
public class RunTest extends AbstractTestNGCucumberTests {
}

