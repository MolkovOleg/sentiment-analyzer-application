package com.molkovor.sentimentanalyzerapplication.model;

import java.util.Map;

public record ModelDefinition(Double bias, Map<String, Double> weights) {
}
