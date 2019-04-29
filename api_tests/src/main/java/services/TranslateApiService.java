package services;

import models.DetectResponse;
import models.TranslateResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
public interface TranslateApiService {

    @POST("/api/v1.5/tr.json/detect")
    Call<DetectResponse> detect(@Query("key") String token,
                                @Field("text") String text);

    @POST("/api/v1.5/tr.json/translate")
    Call<TranslateResponse> translate(@Query("lang") String lang,
                                      @Query("key") String token,
                                      @Field("text") String text);

}
