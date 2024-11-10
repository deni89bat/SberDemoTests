package api.steps;

import api.adapters.APIAdapter;
import api.dto.RequestNewPet;
import io.restassured.response.Response;

public class PetSteps {
    private final APIAdapter apiAdapter;

    public PetSteps(String baseUrl) {
        this.apiAdapter = new APIAdapter(baseUrl);
    }

    public Response addPet(RequestNewPet pet) {
        return apiAdapter.post("/pet", pet);
    }

    public Response getPetById(int petId) {
        return apiAdapter.get("/pet/" + petId);
    }

    public Response deletePet(int petId) {
        return apiAdapter.delete("/pet/" + petId);
    }
}
