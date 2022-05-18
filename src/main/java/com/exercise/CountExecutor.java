package com.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CountExecutor {

    public List<CountResult> getCountOfVowelsAndConsonants(String[] strings) {
        final VowelCounter counter = new VowelCounter();
        final var result = counter.getStringsWithNumbersOfVowelAndConsonant(strings);
        log.info("Vowel and consonant numbers for string is: {}", result);
        return result;
    }


}
