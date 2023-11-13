package com.example.symbolfrequency;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/symbol-frequency")
public class SymbolFrequencyController {
    @PostMapping
    public SymbolFrequencyResponse calculateSymbolFrequency(@RequestBody SymbolFrequencyRequest request) {
        String inputString = request.getInputString();

        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        frequencies = frequencies.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));

        return new SymbolFrequencyResponse(frequencies);
    }
}
