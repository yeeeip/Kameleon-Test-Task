package com.nuzhd.techtask.service.impl;

import com.nuzhd.techtask.model.Quote;
import com.nuzhd.techtask.repository.QuoteRepository;
import com.nuzhd.techtask.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    @Override
    public Quote create(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote update(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote findById(UUID quoteId) {
        return quoteRepository.findById(quoteId).orElse(null);
    }

    @Override
    public List<Quote> findAll() {
        return quoteRepository.findAll();
    }

    @Override
    public void deleteById(UUID quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    @Override
    public List<Quote> findTop10() {
        return quoteRepository.findAll(Sort.by(Sort.Direction.DESC, "rating")).stream()
                .limit(10)
                .toList();
    }

    @Override
    public List<Quote> findWorst10() {
        return quoteRepository.findAll(Sort.by(Sort.Direction.ASC, "rating")).stream()
                .limit(10)
                .toList();
    }
}
