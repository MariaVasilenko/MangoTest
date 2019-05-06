package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.ProjectConfig;
import models.DetectResponse;
import models.TranslateResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.aeonbits.owner.ConfigFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
public class TranslateApiClient {

    ProjectConfig projectConfig;
    TranslateApiService service;

    public TranslateApiClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        projectConfig = ConfigFactory.create(ProjectConfig.class);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel((projectConfig.testDebug().equals("true")) ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(projectConfig.apiPath())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();

        service = retrofit.create(TranslateApiService.class);
    }

    public DetectResponse detect(String text) throws Exception {
        Call<DetectResponse> responseCall = service.detect(projectConfig.apiToken(), text);
        Response<DetectResponse> response = responseCall.execute();
        if (response.isSuccessful())
            return response.body();
        else throw new Exception("Response is not Successful: \nErrorBody:"+response.errorBody());
    }

    public TranslateResponse translate(String lang, String text) throws Exception {
        Call<TranslateResponse> responseCall = service.translate(lang, projectConfig.apiToken(), text);
        Response<TranslateResponse> response = responseCall.execute();
        if (response.isSuccessful())
            return response.body();
        else throw new Exception("Response is not Successful: \nErrorBody:"+response.errorBody());
    }

}
