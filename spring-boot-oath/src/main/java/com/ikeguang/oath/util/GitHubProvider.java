package com.ikeguang.oath.util;

import com.alibaba.fastjson.JSON;
import com.ikeguang.oath.model.GitHubAccessModel;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class GitHubProvider {
    public String getAccessToken(GitHubAccessModel gitHubAccessModel){
        log.info(gitHubAccessModel.toString());
        MediaType mediaType= MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(gitHubAccessModel));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(response.isSuccessful());
            System.out.println(string);
            return string;
        } catch (IOException e) {
        }
        return null;
    }
}
