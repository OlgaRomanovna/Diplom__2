package client;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.Ingredient;

import java.util.ArrayList;

public class OrdersApiClient extends BaseHttpClient {
    private final String baseUrl = "https://stellarburgers.nomoreparties.site/api";

    @Step("Создание заказа")
    public Response createOrder(ArrayList<Ingredient> ingredients) {
        ArrayList<String> ids = new ArrayList<>();

        for (Ingredient ing : ingredients) {
            ids.add(ing._id);
        }

        CreateOrderRequest request = new CreateOrderRequest(ids);
        return doPostRequest(baseUrl + "/orders", request);
    }

    @Step("Создание заказа с токеном")
    public Response createOrder(ArrayList<Ingredient> ingredients, String accessToken) {
        ArrayList<String> ids = new ArrayList<>();

        for (Ingredient ing : ingredients) {
            ids.add(ing._id);
        }

        CreateOrderRequest request = new CreateOrderRequest(ids);
        return doPostRequest(baseUrl + "/orders", request, accessToken);
    }

    @Step("Получение заказа")
    public Response getOrders() {
        return doGetRequest(baseUrl + "/orders");
    }

    @Step("Получение заказа с токеном")
    public Response getOrders(String accessToken) {
        return doGetRequest(baseUrl + "/orders", accessToken);
    }
}
