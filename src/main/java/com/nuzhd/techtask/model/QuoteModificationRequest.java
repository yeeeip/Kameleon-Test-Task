package com.nuzhd.techtask.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class QuoteModificationRequest {

    private String content;
    private UUID authorId;

}
