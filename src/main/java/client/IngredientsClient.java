package client;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class IngredientsClient extends BaseHttpClient {
    private final String baseUrl = "https://stellarburgers.nomoreparties.site/api";

    @Step("Получение ингредиентов")
    public Response getIngredients () {
        return doGetRequest(baseUrl + "/ingredients");
    }
}