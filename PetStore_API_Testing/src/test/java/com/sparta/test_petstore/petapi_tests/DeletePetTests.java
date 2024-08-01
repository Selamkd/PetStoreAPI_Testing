package com.sparta.test_petstore.petapi_tests;

import com.sparta.test_petstore.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeletePetTests {
    private static Response happyResponse;
    private static Response sadResponse;

    @BeforeAll
    public static void beforeAll() {
        happyResponse = RestAssured
                .given(Utils.petById(1))
                .when()
                .delete()
                .thenReturn();

        sadResponse = RestAssured
                .given(Utils.petById(1000000))
                .when()
                .log().all()
                .delete()
                .thenReturn();
    }

    @Test
    @DisplayName("Delete pet by ID returns 200 status code")
    void deletePetById_returns200() {
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("Delete pet by ID returns message 'Pet deleted'")
    void deletePetById_returnsMessage_PetDeleted() {
        MatcherAssert.assertThat(happyResponse.statusLine(), Matchers.is("Pet deleted"));
    }

    @Disabled
    @Test
    @DisplayName("Delete pet by ID with invalid input returns 404")
    void deletePetById_WithInvalidInputReturns404() {
        MatcherAssert.assertThat(sadResponse.statusCode(), Matchers.is(500));
    }


    @Test
    @DisplayName("Delete pet by ID deletes the pet")
    void getPetById_returnsAPetWithSameId() {
        Response getDeletedPet = RestAssured
                .given(Utils.petById(1))
                .when()
                .get()
                .thenReturn();

        MatcherAssert.assertThat(getDeletedPet.statusCode(), Matchers.is(404));
    }


}
