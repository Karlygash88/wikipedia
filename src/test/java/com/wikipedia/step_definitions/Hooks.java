package com.wikipedia.step_definitions;

import com.wikipedia.utilities.ConfigurationReader;
import com.wikipedia.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUpScenario(){
        Driver.getDriver().get(ConfigurationReader.getProperty("wiki_url"));
    }

    @After
    public void tearDownScenario(){
        Driver.closeDriver();
    }

}
