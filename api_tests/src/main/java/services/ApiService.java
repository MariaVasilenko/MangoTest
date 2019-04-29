package services;

import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import retrofit2.Retrofit;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
public abstract class ApiService {

    public Retrofit.Builder setup() {

        String apiUrl = ConfigFactory
                .create(ProjectConfig.class).apiPath();

        return new Retrofit
                .Builder()
                .baseUrl(apiUrl);

//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonCustomConverterFactory.create(json.getGson()));
    }

}
