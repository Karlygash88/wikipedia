package com.wikipedia.step_definitions;

import com.wikipedia.pages.HomePage;
import com.wikipedia.pages.SearchPage;
import com.wikipedia.utilities.ConfigurationReader;
import com.wikipedia.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchFunctionality_StepDefinition {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wiki_url"));
        String actualTitle = Driver.getDriver().getTitle();
        String expectedIn = "Wikipedia";
        Assert.assertTrue(actualTitle.contains(expectedIn));

    }

    @When("User types {string} in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box(String string) {
        homePage.searchInput.sendKeys(string);

    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        homePage.searchButton.click();

    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title(String string) {
        String actualTile = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTile.contains(string));
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String expected) {
        String actualText = searchPage.mainHeader.getText();
        Assert.assertEquals(expected,actualText);

    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String expectedText) {
        String actualImageHeaderText = searchPage.imageHeader.getText();
        Assert.assertEquals(expectedText,actualImageHeaderText);

    }
}
