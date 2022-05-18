package com.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class VowelCounter {

    public List<CountResult> getStringsWithNumbersOfVowelAndConsonant(String[] args) {
        if (args.length >= 4) {
            throw new TooManyArgumentsException();
        } else {
            List<String> argumentList = Arrays.asList(args);
            return argumentList.stream()
                    .map(this::getCountResult)
                    .collect(Collectors.toList());
        }
    }

    private CountResult getCountResult(String argument) {
        return CountResult.builder()
                .word(argument)
                .vowelCount(getVowelCount(argument))
                .consonantCount(getConsonantCount(argument))
                .build();
    }

    private long getVowelCount(String input) {
        String[] inputChars = input.split("");
        return Arrays.stream(inputChars)
                .filter(inputChar -> inputChar.matches("[aeiouywAEIOUYW]")).count();
    }

    private long getConsonantCount(String input) {
        String[] inputChars = input.split("");
        return Arrays.stream(inputChars)
                .filter(inputChar -> inputChar.matches("[bcdfghjklmnpqrstvxzBCDFGHJKLMNPQRSTVXZ]")).count();
    }
}
