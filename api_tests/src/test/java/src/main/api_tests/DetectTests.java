package src.main.api_tests;

import models.DetectResponse;
import org.junit.jupiter.api.Test;
import services.TranslateApiClient;

import java.io.IOException;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
public class DetectTests{

    @Test
    public void test1() throws IOException {
        DetectResponse response = new TranslateApiClient().detect("katze");

    }

}
