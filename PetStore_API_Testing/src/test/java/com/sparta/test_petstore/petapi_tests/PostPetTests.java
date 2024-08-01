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

public class PostPetTests {
    private static Response happyResponse;
    private static Response sadResponse;
    private static Pet happyPet;



    @BeforeAll
    public static void beforeAll() throws JsonProcessingException {

        Category category = new Category(1, "Dogs");
        TagsItem tag = new TagsItem(0, "String");
        List<String> photoUrls = new ArrayList<>();
        List<TagsItem> tags = new ArrayList<>();
        photoUrls.add("Test photo");
        tags.add(tag);
        Pet pet = new Pet(105, "Horse",
                category, photoUrls, tags, "available");

        happyResponse = RestAssured
                .given(Utils.petBody(pet))
                .when()
                .log().all()
                .post()
                .thenReturn();

        happyPet = happyResponse.getBody().as(Pet.class);

    }

    @Test
    @DisplayName("Successfully adding a valid pet")
    void postPetByBody(){
        MatcherAssert.assertThat(happyResponse.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("New added pet has the same id")
    void newPetSameName(){
        MatcherAssert.assertThat(happyPet.getId(), Matchers.is(105));
    }

}
