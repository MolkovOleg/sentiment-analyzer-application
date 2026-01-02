package com.molkovor.sentimentanalyzerapplication;

import com.molkovor.sentimentanalyzerapplication.service.SentimentResult;
import com.molkovor.sentimentanalyzerapplication.service.SentimentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    private final SentimentService sentimentService;

    public MainController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @GetMapping("/sentiment")
    public SentimentResponse sentiment(@RequestParam("text") String text) {
        SentimentResult result = sentimentService.analyze(text);
        return new SentimentResponse(result.sentiment(), result.confidence());
    }
}

