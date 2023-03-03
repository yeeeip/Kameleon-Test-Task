package com.nuzhd.task.service.impl;

import com.nuzhd.task.model.Quote;
import com.nuzhd.task.repository.QuoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuoteServiceImplTest {

    @Mock
    private QuoteRepository quoteRepository;

    @InjectMocks
    private QuoteServiceImpl quoteService;

    @Test
    void createQuote_WhenGivenQuote_ReturnsQuote() {
        Quote quote = getTestQuotes().get(1);

        when(quoteRepository.save(quote)).thenReturn(quote);

        Quote result = quoteService.create(quote);

        assertNotNull(result);
        assertEquals(quote, result);
    }

    @Test
    void findById_WhenGivenCorrectId_ReturnsQuote() {
        Quote quote = getTestQuotes().get(2);

        when(quoteRepository.findById(quote.getId()))
                .thenReturn(Optional.of(quote));

        Quote result = quoteService.findById(quote.getId());

        assertNotNull(result);
        assertEquals(quote, result);
    }

    @Test
    void findAll_ReturnsAllQuotes() {

        List<Quote> allQuotes = getTestQuotes();

        when(quoteRepository.findAll()).thenReturn(getTestQuotes());

        List<Quote> result = quoteService.findAll();

        assertIterableEquals(result, allQuotes);
    }

    private List<Quote> getTestQuotes() {

        Quote q1 = new Quote(UUID.fromString("3422b448-2460-4fd2-9183-8000de6f8343"),
                "Test content_1",
                LocalDateTime.of(2020, 3, 5, 10, 40),
                null,
                UUID.fromString("4896c91b-9e61-3129-87b6-8aa299028058"),
                0
        );

        Quote q2 = new Quote(UUID.fromString("29be0ee3-fe77-331e-a1bf-9494ec18c0ba"),
                "Test content_2",
                LocalDateTime.of(2021, 5, 22, 14, 40),
                LocalDateTime.of(2021, 5, 24, 10, 22),
                UUID.fromString("4896c91b-9e61-3129-87b6-8aa299028058"),
                14
        );
        Quote q3 = new Quote(UUID.fromString("33b06619-1ee7-3db5-827d-0dc85df1f759"),
                "Test content_3",
                LocalDateTime.of(2017, 10, 8, 7, 1),
                LocalDateTime.of(2019, 12, 20, 19, 40),
                UUID.fromString("4896c91b-9e61-3129-87b6-8aa299028058"),
                15
        );
        Quote q4 = new Quote(UUID.fromString("45719f29-7ae4-4171-b1da-9ea1e08de038"),
                "Test content_4",
                LocalDateTime.of(2022, 9, 1, 18, 20),
                null,
                UUID.fromString("4896c91b-9e61-3129-87b6-8aa299028058"),
                - 6
        );
        Quote q5 = new Quote(UUID.fromString("f000aad3-8076-4cb3-b77c-e35caf96d37a"),
                "Test content_5",
                LocalDateTime.of(2023, 1, 5, 20, 43),
                null,
                UUID.fromString("4896c91b-9e61-3129-87b6-8aa299028058"),
                1
        );
        Quote q6 = new Quote(UUID.fromString("c3a2fe2a-54df-43c4-ae00-c07ebb5fa60a"),
                "Test content_6",
                LocalDateTime.of(2019, 7, 29, 17, 0),
                null,
                UUID.fromString("0d25e538-20fe-4bed-ac63-3a472b6f4efe"),
                19
        );
        Quote q7 = new Quote(UUID.fromString("94c0214b-fffb-4fd3-902b-8243577ca8f9"),
                "Test content_7",
                LocalDateTime.of(2021, 2, 10, 13, 40),
                null,
                UUID.fromString("0d25e538-20fe-4bed-ac63-3a472b6f4efe"),
                17
        );
        Quote q8 = new Quote(UUID.fromString("17a88afa-249e-49ea-b66d-0add4cf9530f"),
                "Test content_8",
                LocalDateTime.of(2015, 11, 27, 17, 10),
                null,
                UUID.fromString("0d25e538-20fe-4bed-ac63-3a472b6f4efe"),
                22
        );
        Quote q9 = new Quote(UUID.fromString("900ad0fb-6d82-41d5-812d-24f806f4a2f2"),
                "Test content_9",
                LocalDateTime.of(2018, 6, 20, 8, 15),
                null,
                UUID.fromString("0d25e538-20fe-4bed-ac63-3a472b6f4efe"),
                3
        );
        Quote q10 = new Quote(UUID.fromString("892f4b93-633f-40b8-a5dd-9153b6d80c40"),
                "Test content_10",
                LocalDateTime.of(2019, 3, 5, 10, 40),
                LocalDateTime.of(2022, 4, 17, 16, 30),
                UUID.fromString("0d25e538-20fe-4bed-ac63-3a472b6f4efe"),
                - 4
        );

        return Arrays.asList(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10);
    }

}