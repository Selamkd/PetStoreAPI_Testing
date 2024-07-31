package com.sparta.test_petstore.pojo;

public record PetRecord(String id, String name, Category category, String photoUrls,
                        TagsItem tagsItem, String status) {
}
