package api.adapters;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIAdapter {
    private final String baseUrl;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public APIAdapter(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private RequestSpecification requestSpec() {
        return RestAssured.given().baseUri(baseUrl).header("Content-Type", "application/json").log().all();
    }

    public <T> Response post(String endpoint, T body) {
        return requestSpec().body(body).post(endpoint).then().log().all().extract().response();
    }

    public Response get(String endpoint) {
        return requestSpec().get(endpoint).then().log().all().extract().response();
    }

    public Response delete(String endpoint) {
        return requestSpec().delete(endpoint).then().log().all().extract().response();
    }
}
