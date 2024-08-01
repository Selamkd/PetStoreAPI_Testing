package com.sparta.test_petstore.petapi_tests;

import com.sparta.test_petstore.Utils;
import com.sparta.test_petstore.pojo.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetPetByIdTests {
    private static Response happyResponse;
    private static Response sadResponse;
    private static Pet happyPet;



    @BeforeAll
    public static void beforeAll(){
        happyResponse = RestAssured
                .given(Utils.petById(1))
                .when()
                .get()
                .thenReturn();
        happyPet = happyResponse.getBody().as(Pet.class);
        sadResponse = RestAssured
                .given(Utils.petById(10000))
                .when()
                .get()
                .thenReturn();
    }


    @Test
    @DisplayName("Get pet by ID returns 200 status code")
    void getPetById_returns200() {
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("Get pet by ID with invalid input returns 404")
    void getPetById_WithInvalidInputReturns404() {
        MatcherAssert.assertThat(sadResponse.statusCode(), Matchers.is(404));
    }


   @Test
   @DisplayName("Get pet by ID returns a pet with the same ID")
   void getPetById_returnsAPetWithSameId() {
        MatcherAssert.assertThat(happyPet.getId(), Matchers.is(1));
   }
   
   
   @Test
   @DisplayName("Get pet by ID returns a pet with the name Cat 1")
   void getPetByIdReturnsAPetWithTheNameCat1() {
       MatcherAssert.assertThat(happyPet.getName(), Matchers.is("Cat 1"));
       
   }


}
