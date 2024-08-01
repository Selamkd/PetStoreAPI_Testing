package com.sparta.test_petstore.storeapi_tests;

import com.sparta.test_petstore.Utils;
import com.sparta.test_petstore.pojo.Order;
import com.sparta.test_petstore.pojo.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetPurchaseOrderByIDTests {
    private static Response happyResponse;
    private static Response sadResponse;
    private static Order happyOrder;



    @BeforeAll
    public static void beforeAll(){
        happyResponse = RestAssured
                .given(Utils.orderById(1))
                .when()
                .get()
                .thenReturn();
        happyOrder = happyResponse.getBody().as(Order.class);
        sadResponse = RestAssured
                .given(Utils.orderById(10000))
                .when()
                .get()
                .thenReturn();
    }


    @Test
    @DisplayName("Get order by ID returns 200 status code")
    void getOrderById_returns200() {
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("Get order by ID with invalid input returns 404")
    void getOrderById_WithInvalidInputReturns404() {
        MatcherAssert.assertThat(sadResponse.statusCode(), Matchers.is(404));
    }


    @Test
    @DisplayName("Get order by ID returns an order with the matching ID")
    void getOrderById_returnsAPetWithSameId() {
        MatcherAssert.assertThat(happyOrder.getId(), Matchers.is(1));
    }


    @Test
    @DisplayName("Get order by ID returns an order with the status placed")
    void getOrderByIdReturnsAPetWithTheNameCat1() {
        MatcherAssert.assertThat(happyOrder.getStatus(), Matchers.is("placed"));
    }
}
