package tests;

import models.DetectResponse;
import models.TranslateResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.TranslateApiClient;

import java.util.ArrayList;

/**
 * Created by Maria Vasilenko on 29.04.2019
 * maria.vasilenko.a@gmail.com
 */
public class TranslateTest {

    private TranslateApiClient client = new TranslateApiClient();

    @Test
    void detectLangAndTranslateToRusKatze() throws Exception {
        String text = "katze";
        DetectResponse detect = client.detect(text);
        assertDetect(detect);
        TranslateResponse translate = client.translate(detect.getLang() + "-ru", text);
        assertTranslate(translate, buildExpectedTranslate(200, "кошка", "ru"));
    }

    @Test
    void detectLangAndTranslateToRusLeChat() throws Exception {
        String text = "le chat";
        DetectResponse detect = client.detect(text);
        assertDetect(detect);
        TranslateResponse translate = client.translate(detect.getLang() + "-ru", text);
        assertTranslate(translate, buildExpectedTranslate(200, "кошка", "ru"));
    }

    @Test
    void detectLangAndTranslateToRusKishka() throws Exception {
        String text = "кішка";
        DetectResponse detect = client.detect(text);
        assertDetect(detect);
        TranslateResponse translate = client.translate(detect.getLang() + "-ru", text);
        assertTranslate(translate, buildExpectedTranslate(200, "кошка", "ru"));
    }

    private TranslateResponse buildExpectedTranslate(int code, String text, String lang) {
        TranslateResponse expected = new TranslateResponse();
        ArrayList<String> textList = new ArrayList<String>();
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

    private void assertDetect(DetectResponse detectResponse) {
        Assertions.assertEquals(200, detectResponse.getCode());
        Assertions.assertNotEquals("", detectResponse.getLang());
    }

}
