package com.nuzhd.techtask.repository;

import com.nuzhd.techtask.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuoteRepository extends JpaRepository<Quote, UUID> {
}
