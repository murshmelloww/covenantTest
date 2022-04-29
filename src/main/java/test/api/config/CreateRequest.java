package test.api.config;

import test.api.models.request.launcher.LauncherBody;
import test.api.models.request.listener.HttpListenerBody;
import test.api.models.request.login.LoginBody;
import test.api.models.request.users.CreateUserBody;
import test.api.models.response.grunt.ResponseGruntItem;
import test.api.models.response.hostedfiles.ResponseHostedFilesItem;
import test.api.models.response.launcher.ResponseLauncher;
import test.api.models.response.listener.ResponseHttpListener;
import test.api.models.response.login.ResponseLogin;
import test.api.models.response.users.ResponseUsers;
import io.restassured.response.Response;

import java.io.InputStream;

public class CreateRequest {

    public static ResponseLogin post200 (LoginBody body)
    {
        return CovenantEndpointConfig.createLogin(body)
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract()
                .jsonPath()
                .getObject("", ResponseLogin.class);
    }

    public static ResponseUsers postUser201(CreateUserBody body, String token)
    {
        return CovenantEndpointConfig.createUser(body, token)
                .assertThat()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getObject("", ResponseUsers.class);
    }

    public static ResponseHttpListener post200 (HttpListenerBody body, String token)
    {
        return CovenantEndpointConfig.createListener(body, token)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseHttpListener.class);
    }

    public static Response deleteListener204(Integer listenerId, String token)
    {
        return CovenantEndpointConfig.deleteListener(listenerId, token)
                .assertThat()
                .statusCode(204)
                .extract().response();
    }

    public static Response deleteUser204 (String userId, String token)
    {
        return CovenantEndpointConfig.deleteUser(userId, token)
                .assertThat()
                .statusCode(204)
                .extract().response();
    }

    public static ResponseLauncher post200 (String token)
    {
        return CovenantEndpointConfig.createLauncher(token)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseLauncher.class);
    }

    public static InputStream getFile200 (String token)
    {
        return CovenantEndpointConfig.getLauncher(token)
                .assertThat()
                .statusCode(200)
                .extract()
                .response().asInputStream();
    }

    public static ResponseHostedFilesItem[] get200 (String token, Integer listenerId)
    {
        return CovenantEndpointConfig.createHostedFiles(token, listenerId)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseHostedFilesItem[].class);
    }

    public static ResponseGruntItem[] get200 (String token)
    {
        return CovenantEndpointConfig.createGrunts(token)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseGruntItem[].class);
    }


    public static ResponseLauncher put200 (String token, LauncherBody body)
    {
        return CovenantEndpointConfig.generateLauncher(token, body)
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", ResponseLauncher.class);
    }
}
