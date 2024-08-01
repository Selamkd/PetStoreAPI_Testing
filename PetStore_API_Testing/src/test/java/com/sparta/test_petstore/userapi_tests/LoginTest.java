package com.sparta.test_petstore.petapi_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.test_petstore.Utils;
import com.sparta.test_petstore.pojo.*;
import groovy.lang.DelegatesTo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTest {
    private static Response happyResponse;
    private static String respond;


    @BeforeAll
    public static void beforeAll(){

        happyResponse = RestAssured
                .given(Utils.login("user1","XXXXXXXXXXX"))
                .when()
                .get()
                .thenReturn();

        respond = String.valueOf(happyResponse.getBody().asString());

    }

    @Test
    @DisplayName("Successfully created a new account")
    void postNewAccount(){
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("New user have the same ID")
    void newUserHaveSameId(){
        MatcherAssert.assertThat(respond, Matchers.containsString("Logged in user session:"));
    }

}

