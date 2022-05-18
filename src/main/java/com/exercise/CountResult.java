package com.exercise;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class CountResult {
    private String word;
    private long vowelCount;
    private long consonantCount;
}
