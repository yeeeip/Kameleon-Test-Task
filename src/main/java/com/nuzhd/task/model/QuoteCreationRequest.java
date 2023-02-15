package com.nuzhd.task.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class QuoteCreationRequest {

    private String content;
    private UUID authorId;
}
