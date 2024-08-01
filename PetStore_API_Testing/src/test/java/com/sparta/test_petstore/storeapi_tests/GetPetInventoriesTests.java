package com.sparta.test_petstore.storeapi_tests;

import com.sparta.test_petstore.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetPetInventoriesTests {
    private static Response happyResponse;
    private static int responseBodyLength;

    @BeforeAll
    public static void beforeAll() {
        happyResponse = RestAssured
                .given(Utils.storeInventory())
                .when()
                .get()
                .thenReturn();
        responseBodyLength = happyResponse.jsonPath().getMap("").size();
        System.out.println(happyResponse.jsonPath().getMap(""));
    }


    @Test
    @DisplayName("Get store inventory returns status code 200")
    void getStoreInventory_ReturnsStatusCode200() {
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));

    }

    @Test
    @DisplayName("Get store inventory response body length is 2")
    void getStoreInventory_ResponseBodyLengthIs2() {
        MatcherAssert.assertThat(responseBodyLength, Matchers.is(2));

    }

}
