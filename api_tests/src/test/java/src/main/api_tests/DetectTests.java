package src.main.api_tests;

import models.DetectResponse;
import models.TranslateResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.TranslateApiClient;

import java.io.IOException;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
public class DetectTests {

    @Test
    public void detectLangAndTranslateToRus() throws IOException {
        String katze = "katze";
        DetectResponse detect = new TranslateApiClient().detect(katze);
        String lang = detect.getLang();
        TranslateResponse translate = new TranslateApiClient().translate(lang + "-ru", katze);
        Assertions.assertEquals("ru", translate.getLang().split("-")[1]);
        Assertions.assertEquals("кошка", translate.getText().get(0));
        Assertions.assertEquals(200, translate.getCode());
    }

}
