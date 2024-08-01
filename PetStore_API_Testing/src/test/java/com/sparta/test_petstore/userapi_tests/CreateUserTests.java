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
import java.util.ArrayList;
import java.util.List;

public class CreateUserTests {
    private static Response happyResponse;
    private static Response sadResponse;
    private static User user;
    private static User happyUser;


    @BeforeAll
    public static void beforeAll() throws JsonProcessingException {

        user = new User(10, "theUser", "John", "Doe",
                "John@email.com", "Password123", "123456789", 1);

        happyResponse = RestAssured
                .given(Utils.userBody(user))
                .when()
                .post()
                .thenReturn();

        happyUser = happyResponse.getBody().as(User.class);

    }

    @Test
    @DisplayName("Successfully created a new account")
    void postNewAccount(){
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("New user have the same ID")
    void newUserHaveSameId(){
        MatcherAssert.assertThat(happyUser.getId(), Matchers.is(10));
    }

}
