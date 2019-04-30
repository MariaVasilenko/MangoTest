package src.main.api_tests;

import models.DetectResponse;
import models.TranslateResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.TranslateApiClient;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
public class TranslateTests {

    private TranslateApiClient client = new TranslateApiClient();

    @Test
    public void detectLangAndTranslateToRusKatze() throws IOException {
        String text = "katze";
        DetectResponse detect = client.detect(text);
        TranslateResponse translate = client.translate(detect.getLang() + "-ru", text);
        assertTranslate(translate, buildExpectedTranslate(200, "кошка", "ru"));
    }

    @Test
    public void detectLangAndTranslateToRusLeChat() throws IOException {
        String text = "le chat";
        DetectResponse detect = client.detect(text);
        TranslateResponse translate = client.translate(detect.getLang() + "-ru", text);
        assertTranslate(translate, buildExpectedTranslate(200, "кошка", "ru"));
    }

    @Test
    public void detectLangAndTranslateToRusKishka() throws IOException {
        String text = "кішка";
        DetectResponse detect = client.detect(text);
        TranslateResponse translate = client.translate(detect.getLang() + "-ru", text);
        assertTranslate(translate, buildExpectedTranslate(200, "кошка", "ru"));
    }

    private TranslateResponse buildExpectedTranslate(int code, String text, String lang) {
        TranslateResponse expected = new TranslateResponse();
        ArrayList<String> textList = new ArrayList<>();
        textList.add(text);
        expected.setCode(code);
        expected.setLang(lang);
        expected.setText(textList);
        return expected;
    }

    private void assertTranslate(TranslateResponse translate, TranslateResponse expected) {
        Assertions.assertEquals(expected.getCode(), translate.getCode());
        Assertions.assertEquals(expected.getLang(), translate.getLang().split("-")[1]);
        Assertions.assertEquals(expected.getText(), translate.getText());
    }

}
