package com.example.symbolfrequency;

import java.util.Map;

public class SymbolFrequencyResponse {
    private Map<Character, Integer> frequencies;

    public SymbolFrequencyResponse(Map<Character, Integer> frequencies) {
        this.frequencies = frequencies;
    }

    public Map<Character, Integer> getFrequencies() {
        return frequencies;
    }
}
