package api.tests;

import api.dto.Category;
import api.dto.RequestNewPet;
import api.dto.TagsItem;
import api.utils.ApiProps;
import api.steps.PetSteps;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class PetApiTests {
    private static PetSteps petSteps;

    @BeforeAll
    public static void setup() {
        ApiProps config = ConfigFactory.create(ApiProps.class);
        petSteps = new PetSteps(config.baseUrl());
    }

    @Test
    public void testAddGetDeletePet() {
        RequestNewPet pet = RequestNewPet.createNewPet(12345,
                "TestPet",
                "available",
                new Category("Dogs", 1),
                List.of(new TagsItem("dogTagBat", 666)),
                Collections.singletonList("https://test.url/photo"));

        // Добавляем Pet
        Response addResponse = petSteps.addPet(pet);
        Assertions.assertEquals(200, addResponse.statusCode());

        //Получаем Pet по ID
        Response getResponse = petSteps.getPetById(pet.getId());
        RequestNewPet retrievedPet = getResponse.as(RequestNewPet.class);
        Assertions.assertEquals(pet.getName(), retrievedPet.getName());

        // Удаляем Pet
        Response deleteResponse = petSteps.deletePet(pet.getId());
        Assertions.assertEquals(200, deleteResponse.statusCode());
    }
}
