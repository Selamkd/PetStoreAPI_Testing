package com.sparta.test_petstore;

import com.sparta.test_petstore.pojo.PetRecord;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Utils {
    
    private static final String BASE_URI = AppConfig.getBaseUri();
    private static final String PET_BY_ID_PATH = AppConfig.getPetByIdPath();
    private static final String PET_BODY_PATH = AppConfig.getPetBodyPath();

    public static RequestSpecification getPetById(Integer id){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PET_BY_ID_PATH)
                .addPathParams(Map.of(
                        "id", id
                )).build();
    }
    // Use for post and put, same uri
    public static RequestSpecification petBody(PetRecord petRecord){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PET_BODY_PATH)
                .setContentType(ContentType.JSON)
                .setBody(Map.of("body", petRecord))
                .build();
    }


}
