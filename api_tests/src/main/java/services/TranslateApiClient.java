package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.ProjectConfig;
import lombok.extern.slf4j.Slf4j;
import models.DetectResponse;
import models.TranslateResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.aeonbits.owner.ConfigFactory;
import org.aspectj.lang.annotation.Aspect;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
@Slf4j
public class TranslateApiClient {

    ProjectConfig projectConfig;
    TranslateApiService service;

    public TranslateApiClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);


        projectConfig = ConfigFactory.create(ProjectConfig.class);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(projectConfig.apiPath())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client.build())
                .build();

        service = retrofit.create(TranslateApiService.class);
    }

    public Response<DetectResponse> detectResponse(String text) throws IOException {
        Call<DetectResponse> responseCall = service.detect(projectConfig.apiToken(), text);
        return responseCall.execute();
    }

    public DetectResponse detect(String text) throws IOException {
        Response<DetectResponse> response = detectResponse(text);
        DetectResponse data = new DetectResponse();
        if(response.isSuccessful()) {
            data = response.body();
            System.out.println(data);
        } else {
            System.out.println(response.errorBody());
        }
        return data;
    }

    public Response<TranslateResponse> translate(String lang, String text) throws IOException {
        Call<TranslateResponse> responseCall = service.translate(lang, projectConfig.apiToken(), text);
        return responseCall.execute();
    }

}
