package com.fintrack.finance.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MarketDataFetcher {

    public String fetchMarketData(String assetName) {
        // Implement logic to fetch market data from a third-party API
        // For simplicity, this example returns a static response
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.example.com/market-data?asset=" + assetName;
        return restTemplate.getForObject(apiUrl, String.class);
    }
}