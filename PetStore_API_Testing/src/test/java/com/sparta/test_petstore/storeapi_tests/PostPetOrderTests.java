package com.sparta.test_petstore.storeapi_tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.test_petstore.Utils;
import com.sparta.test_petstore.pojo.Order;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PostPetOrderTests {
    private static Response happyResponse;
    private static Response sadResponse;
    private static Order happyOrder;



    @BeforeAll
    public static void beforeAll() throws JsonProcessingException {
        Order order = new Order(1, 105, 2, "2024-08-01T00:00:00Z",false,"placed");

        happyResponse = RestAssured
                .given(Utils.orderBody(order))
                .when()
                .log().all()
                .post()
                .thenReturn();

        happyOrder = happyResponse.getBody().as(Order.class);

    }

    @Test
    @DisplayName("Successfully placing an order")
    void postPetByBody(){
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("New order has the same id")
    void newPetSameName(){
        MatcherAssert.assertThat(happyOrder.getId(), Matchers.is(2));
    }
}
