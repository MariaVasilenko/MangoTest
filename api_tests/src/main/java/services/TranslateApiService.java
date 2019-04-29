package services;

import models.DetectResponse;
import models.TranslateResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
public interface TranslateApiService {
    @FormUrlEncoded
    @Headers({"Accept: */*"})
    @POST("api/v1.5/tr.json/detect")
    Call<DetectResponse> detect(@Query(value="key", encoded=true) String token,
                                @Field("text") String text);
    @FormUrlEncoded
    @POST("api/v1.5/tr.json/translate")
    Call<TranslateResponse> translate(@Query("lang") String lang,
                                      @Query("key") String token,
                                      @Field("text") String text);
}
