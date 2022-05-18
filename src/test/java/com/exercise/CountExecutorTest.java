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

    //WILL FAIL due to special character existing
    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForSingleSentenceWithSpecCharacters() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"JerryMouse&&!! **%%??,,TomCat"});
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
        Optional<Long> sumVowRes = listRes.stream().map(CountResult::getVowelCount).reduce(Long::sum);
        Optional<Long> sumConsRes = listRes.stream().map(CountResult::getConsonantCount).reduce(Long::sum);
        assertAll(
                () -> assertThat(sumVowRes.get() == 9).isTrue(),
                () -> assertThat(sumConsRes.get() == 12).isTrue()
        );
    }

    @Test
    void userIsNotAbleToSeeNumberOfVowelsAndConsonantFor4StringOrMore() {
        assertThrows(RuntimeException.class, () -> exec.getCountOfVowelsAndConsonants(new String[]{"AA", "BB", "CC", "DD"}));
        assertThrows(RuntimeException.class, () -> exec.getCountOfVowelsAndConsonants(new String[]{"A", "B", "C", "D", "E"}));
    }

    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForSeveralEmptyStrings() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"", "", ""});
        assertAll(
                () -> assertThat(listRes.stream().allMatch(e -> e.getVowelCount() == 0)).isTrue(),
                () -> assertThat(listRes.stream().allMatch(e -> e.getConsonantCount() == 0)).isTrue()
        );
    }

    //actually cow contains 1 consonant and 2 vowels WILL FAIL
    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForStringIfWorYRepresentAsVowels() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"cow"});
        assertAll(
                () -> assertThat(listRes.stream().allMatch(e -> e.getVowelCount() == 1)).isTrue(),
                () -> assertThat(listRes.stream().allMatch(e -> e.getConsonantCount() == 2)).isTrue()
        );
    }

    // due to null WILL FAIL as java.lang.NullPointerException
    @Test
    void userAbleToSeeNumberOfVowelsAndConsonantForEmptyAndNullStrings() {
        List<CountResult> listRes = exec.getCountOfVowelsAndConsonants(new String[]{"", null, ""});
        assertAll(
                () -> assertThat(listRes.stream().allMatch(e -> e.getVowelCount() == 0)).isTrue(),
                () -> assertThat(listRes.stream().allMatch(e -> e.getConsonantCount() == 0)).isTrue()
        );
    }

}