package com.molkovor.sentimentanalyzerapplication.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class SentimentModelLoader {

    private SentimentModelLoader() {
    }

    public static SentimentModel load(ObjectMapper mapper, String path) {
        try (InputStream is = SentimentModelLoader.class.getResourceAsStream(path)) {
            if (is == null) {
                throw new IllegalStateException("Не найден ресурс модели: " + path);
            }
            ModelDefinition definition = mapper.readValue(is, ModelDefinition.class);

            return new SentimentModel(definition.bias(), definition.weights());
        } catch (IOException ex) {
            throw new IllegalStateException("Не удалось прочитать модель тональности ", ex);
        }
    }
}
