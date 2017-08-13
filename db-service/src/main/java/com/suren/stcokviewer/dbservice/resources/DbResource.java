package com.suren.stcokviewer.dbservice.resources;

import com.suren.stcokviewer.dbservice.com.suren.stockviewer.dbservice.model.QuoteModel;
import com.suren.stcokviewer.dbservice.entity.Quote;
import com.suren.stcokviewer.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Surendirababu Janarthanan on 8/13/2017.
 */
@RestController
@RequestMapping("/rest/db")
public class DbResource {

    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping("/{userName}")
    public List<String> getQuotes(@PathVariable("userName") String userName) {
        return getQuotesByUserName(userName);

    }

    private List<String> getQuotesByUserName(@PathVariable("userName") String userName) {
        return quotesRepository.findByUserName(userName)
                .stream()
                .map(quote -> quote.getQuote())
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> addQuotes(@RequestBody QuoteModel quote) {
        quote.getQuotename().stream().forEach(q -> {
            quotesRepository.save(new Quote(quote.getUsername(), q));
        });

        return getQuotesByUserName(quote.getUsername());
    }

    @DeleteMapping("/delete/{userName}")
    public List<String> deleteQuotesForUserName(@PathVariable("userName") String userName) {

        quotesRepository.findByUserName(userName).stream().forEach(quote -> quotesRepository.delete(quote));
        return getQuotesByUserName(userName);

    }
}