package com.sparta.test_petstore.storeapi_tests;

import com.sparta.test_petstore.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeletePurchaseOrderTests {
    private static Response happyResponse;
    private static Response sadResponse;

    @BeforeAll
    public static void beforeAll() {
        happyResponse = RestAssured
                .given(Utils.orderById(1))
                .when()
                .delete()
                .thenReturn();

        sadResponse = RestAssured
                .given(Utils.orderById(10000))
                .when()
                .delete()
                .thenReturn();
    }

    @Test
    @DisplayName("Delete order by ID returns 200 status code")
    void deleteOrderById_returns200() {
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));
    }
    @Disabled
    @Test
    @DisplayName("Delete order by ID with invalid input returns 404")
    void deleteOrderById_WithInvalidInputReturns404() {
        MatcherAssert.assertThat(sadResponse.statusCode(), Matchers.is(404));
    }


    @Test
    @DisplayName("Delete order by ID deletes the order")
    void deleteOrderById_deletesTheOrder() {
        Response getDeletedPet = RestAssured
                .given(Utils.orderById(1))
                .when()
                .get()
                .thenReturn();

        MatcherAssert.assertThat(getDeletedPet.statusCode(), Matchers.is(404));
    }
}
