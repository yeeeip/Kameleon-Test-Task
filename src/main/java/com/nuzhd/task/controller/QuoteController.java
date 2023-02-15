package com.nuzhd.task.controller;

import com.nuzhd.task.model.Quote;
import com.nuzhd.task.model.QuoteCreationRequest;
import com.nuzhd.task.model.QuoteModificationRequest;
import com.nuzhd.task.model.User;
import com.nuzhd.task.repository.QuoteRepository;
import com.nuzhd.task.service.QuoteService;
import com.nuzhd.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final UserService userService;
    private final QuoteService quoteService;
    private final QuoteRepository quoteRepository;

    @PostMapping
    public ResponseEntity<Quote> addQuote(@RequestBody QuoteCreationRequest quoteCreationRequest) {

        User author = userService.findById(quoteCreationRequest.getAuthorId());

        if (author == null) {
            return ResponseEntity.notFound().build();
        }

        Quote quote = Quote.builder()
                .content(quoteCreationRequest.getContent())
                .rating(0)
                .createdAt(LocalDateTime.now())
                .userId(author.getId())
                .build();

        Quote createdQuote = quoteService.create(quote);

        return ResponseEntity.created(
                        URI.create("http://localhost:8080/api/v1/quotes/" + createdQuote.getId()))
                .body(createdQuote);
    }

    @GetMapping("/{quoteId}")
    public ResponseEntity<Quote> viewQuote(@PathVariable("quoteId") UUID quoteId) {

        Quote foundQuote = quoteService.findById(quoteId);

        if (foundQuote == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(foundQuote);
    }

    @GetMapping("/random")
    public ResponseEntity<Quote> getRandomQuote() {
        List<Quote> allQuotes = quoteRepository.findAll();

        if (allQuotes.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allQuotes.get(new Random().nextInt(allQuotes.size())));
    }

    @DeleteMapping("/{quoteId}")
    public ResponseEntity deleteQuote(@PathVariable("quoteId") UUID quoteId) {

        Quote quoteToDelete = quoteService.findById(quoteId);

        if (quoteToDelete == null) {
            return ResponseEntity.notFound().build();
        }

        quoteService.deleteById(quoteId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{quoteId}")
    public ResponseEntity<Quote> editQuote(@PathVariable("quoteId") UUID quoteId, @RequestBody QuoteModificationRequest quoteModificationRequest) {

        Quote quoteToEdit = quoteService.findById(quoteId);

        if (quoteToEdit == null) {
            return ResponseEntity.notFound().build();
        }

        quoteToEdit.setContent(quoteModificationRequest.getContent());
        quoteToEdit.setUserId(quoteModificationRequest.getAuthorId());
        quoteToEdit.setUpdatedAt(LocalDateTime.now());

        return ResponseEntity.ok(quoteService.update(quoteToEdit));

    }

    @GetMapping
    public ResponseEntity<List<Quote>> getTop10Quotes(@RequestParam(value = "viewMode", defaultValue = "best") String view) {

        if (view.equals("best")) {
            return ResponseEntity.ok(quoteService.findTop10());
        } else if (view.equals("worst")) {
            return ResponseEntity.ok(quoteService.findWorst10());
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{quoteId}/vote")
    public ResponseEntity<Quote> upvoteQuote(@PathVariable("quoteId") UUID quoteId, @RequestParam("mode") String voting) {

        Quote quoteToUpvote = quoteService.findById(quoteId);

        if (quoteToUpvote == null) {
            return ResponseEntity.notFound().build();
        }

        if (voting.equals("upvote")) {
            quoteToUpvote.setRating(quoteToUpvote.getRating() + 1);
        } else if (voting.equals("downvote")) {
            quoteToUpvote.setRating(quoteToUpvote.getRating() - 1);
        } else {
            return ResponseEntity.badRequest().build();
        }

        quoteToUpvote.setUpdatedAt(LocalDateTime.now());
        quoteService.update(quoteToUpvote);

        return ResponseEntity.ok(quoteToUpvote);
    }
}
