package com.ikeguang.oath;

import com.alibaba.fastjson.JSON;
import com.ikeguang.oath.model.GitHubAccessModel;
import okhttp3.*;
import org.junit.Test;

public class OkhttpTests {

    @Test
    public void test(){
        GitHubAccessModel gitHubAccessModel = new GitHubAccessModel();
        gitHubAccessModel.setCode("67ca05779b19c01b9610");
        gitHubAccessModel.setState("1");
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(gitHubAccessModel));
        System.out.println(gitHubAccessModel);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.isSuccessful());
            System.out.println(response.code());
            String string = response.body().string();
            System.out.println(string);
            String token = string.split("&")[0].split("=")[1];
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
