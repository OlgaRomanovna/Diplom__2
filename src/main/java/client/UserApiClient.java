package client;

import io.qameta.allure.Step;
import models.User;
import io.restassured.response.Response;

public class UserApiClient extends BaseHttpClient {
    private final String baseUrl = "https://stellarburgers.nomoreparties.site/api";

    @Step("Создание пользователя")
    public Response createUser(User user) {
        return doPostRequest(baseUrl + "/auth/register", user);
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String acceesToken) {
        return doDeleteRequest(baseUrl + "/auth/user", acceesToken);
    }

    @Step("Авторизация пользователя")
    public Response loginUser(User user) {
        return doPostRequest(baseUrl + "/auth/login", user);
    }

    @Step("Изменение информации о пользователе")
    public Response changeUserInfo(User user, String accessToken) {
        return doPatchRequest(baseUrl + "/auth/user", user, accessToken);
    }

    @Step("Изменение информации о пользователе без токена")
    public Response changeUserInfoWithoutAuthorization(User user) {
        return doPatchRequest(baseUrl + "/auth/user", user);
    }
}
