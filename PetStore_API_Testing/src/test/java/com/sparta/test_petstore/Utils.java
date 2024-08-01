package com.sparta.test_petstore;
import com.sparta.test_petstore.pojo.Order;
import com.sparta.test_petstore.pojo.Pet;
import com.sparta.test_petstore.pojo.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class Utils {
    
    private static final String BASE_URI = AppConfig.getBaseUri();
    private static final String PET_BY_ID_PATH = AppConfig.getPetByIdPath();
    private static final String PET_BODY_PATH = AppConfig.getPetBodyPath();
    private static final String ORDER_BY_ID_PATH = AppConfig.getStoreByIDPath();
    private static final String USER_BODY = AppConfig.getUserBodyPath();
    private static final String STORE_INVENTORY = AppConfig.getStoreInventory();
    private static final String LOGIN_PATH = AppConfig.getUserLoginPath();
    private static final String ORDER_BODY_PATH = AppConfig.getOrderBodyPath();

    public static RequestSpecification petById(Integer id){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PET_BY_ID_PATH)
                .addPathParams(Map.of(
                        "id", id
                )).build();
    }

    // Use for post and put, same uri
    public static RequestSpecification petBody(Pet pet){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PET_BODY_PATH)
                .setContentType(ContentType.JSON)
                .setBody(pet)
                .build();
    }
    public static RequestSpecification orderBody(Order order){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(ORDER_BODY_PATH)
                .setContentType(ContentType.JSON)
                .setBody(order)
                .build();
    }
    public static RequestSpecification orderById(Integer id){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(ORDER_BY_ID_PATH )
                .addPathParams(Map.of(
                        "id", id
                )).build();
    }

    public static RequestSpecification userBody(User user){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(USER_BODY)
                .setContentType(ContentType.JSON)
                .setBody(user)
                .build();
    }


    public static RequestSpecification storeInventory(){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(STORE_INVENTORY)
                 .build();
    }

    public static RequestSpecification login(String username, String password){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(LOGIN_PATH)
                .addPathParams(Map.of(
                        "username", username,
                        "password", password
                ))
                .build();
    }
}
