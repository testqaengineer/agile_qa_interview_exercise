package com.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CountExecutorTest {

    CountExecutor exec;

    @BeforeEach
    public void setup() {
        exec = new CountExecutor();
    }

    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForSingleWord() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"JerryMouse"});
        assertAll(
                () -> assertThat(listRes.stream().allMatch(e -> e.getVowelCount() == 5)).isTrue(),
                () -> assertThat(listRes.stream().allMatch(e -> e.getConsonantCount() == 5)).isTrue()
        );
    }

    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForSingleSentenceWithSpaces() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"JerryMouse and TomCat"});
        assertAll(
                () -> assertThat(listRes.stream().allMatch(e -> e.getVowelCount() == 8)).isTrue(),
                () -> assertThat(listRes.stream().allMatch(e -> e.getConsonantCount() == 11)).isTrue()
        );
    }

    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForSingleSentenceWithSpecCharacters() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"JerryMouse&&!! and **%%??,,TomCat"});
        assertAll(
                () -> assertThat(listRes.stream().allMatch(e -> e.getVowelCount() == 8)).isTrue(),
                () -> assertThat(listRes.stream().allMatch(e -> e.getConsonantCount() == 11)).isTrue()
        );
    }

    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForSeveralSentencesAsStrings() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"JerryMouse and TomCat", "A and B"});
        assertAll(
                () -> assertThat(listRes.stream().anyMatch(e -> e.getVowelCount() == 8)).isTrue(),
                () -> assertThat(listRes.stream().anyMatch(e -> e.getConsonantCount() == 11)).isTrue(),
                () -> assertThat(listRes.stream().anyMatch(e -> e.getVowelCount() == 2)).isTrue(),
                () -> assertThat(listRes.stream().anyMatch(e -> e.getConsonantCount() == 3)).isTrue()
        );
    }

    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForThreeString() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"JerryMouse", "TomCat", "Space"});
        long sumVowRes = listRes.stream().map(CountResult::getVowelCount).reduce(0L, Long::sum);
        long sumConsRes = listRes.stream().map(CountResult::getConsonantCount).reduce(0L, Long::sum);
        assertAll(
                () -> assertThat(sumVowRes).isSameAs(9L),
                () -> assertThat(sumConsRes).isSameAs(12L)
        );
    }

    @Test
    void userIsNotAbleToSeeNumberOfVowelsAndConsonantFor4StringOrMore() {
        assertThrows(TooManyArgumentsException.class, () -> exec.getCountOfVowelsAndConsonants(new String[]{"AA", "BB", "CC", "DD"}));
        assertThrows(TooManyArgumentsException.class, () -> exec.getCountOfVowelsAndConsonants(new String[]{"A", "B", "C", "D", "E"}));
    }

    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForSeveralEmptyStrings() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"", "", ""});
        assertAll(
                () -> assertThat(listRes.stream().allMatch(e -> e.getVowelCount() == 0)).isTrue(),
                () -> assertThat(listRes.stream().allMatch(e -> e.getConsonantCount() == 0)).isTrue()
        );
    }

    // actually word cow contains 1 consonant and 2 vowels WILL FAIL
    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForStringIfWorYRepresentAsVowels() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"cow"});
        assertAll(
                () -> assertThat(listRes.stream().allMatch(e -> e.getVowelCount() == 1)).isTrue(),
                () -> assertThat(listRes.stream().allMatch(e -> e.getConsonantCount() == 2)).isTrue()
        );
    }

    @Test
    void userAbleToSeeThatOurCountMethodNotPerceivesStringArraysWithNullArguments() {
        assertThrows(NullPointerException.class, () -> exec.getCountOfVowelsAndConsonants(new String[]{"", null, ""}));
    }

}