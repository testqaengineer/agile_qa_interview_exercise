package com.exercise;

public class CountResult {
    private String word;
    private Integer vowelCount;

    public CountResult(String word, Integer vowelCount) {
        this.word = word;
        this.vowelCount = vowelCount;
    }

    public Integer getVowelCount() {
        return vowelCount;
    }

    public void setVowelCount(Integer vowelCount) {
        this.vowelCount = vowelCount;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "word='" + word + '\'' +
                ", vowelCount=" + vowelCount +
                '}';
    }
}
