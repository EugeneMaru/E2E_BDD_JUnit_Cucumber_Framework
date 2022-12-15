package com.project.step_definitions;

import com.project.utils.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.util.List;

public class US01_StepDefs {
    String actualResult;
    List<String> actualList;

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        String query1 = "select count(id) from users";

        DB_Util.runQuery(query1);
        actualResult = DB_Util.getFirstRowFirstColumn();


    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        String query2= "select  count( distinct id) from users";

        DB_Util.runQuery(query2);

        String expectedResult = DB_Util.getCellValue(1, 1);

        Assert.assertEquals(expectedResult, actualResult);


    }

    @When("Execute query to get all columns")
    public void executeQueryToGetAllColumns() {

            DB_Util.runQuery("select * from users");
        actualList = DB_Util.getAllColumnNamesAsList();
    }

    @Then("verify the below columns are listed in result")
    public void verifyTheBelowColumnsAreListedInResult(List<String> expectedList) {

        Assert.assertEquals(expectedList, actualList);

    }
}
