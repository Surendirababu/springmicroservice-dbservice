package com.suren.stcokviewer.dbservice.resources;

import com.suren.stcokviewer.dbservice.entity.Quote;
import com.suren.stcokviewer.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<String> getQuotes(@PathVariable("userName") String userName)
    {
       return quotesRepository.findByUserName(userName)
                .stream()
                .map(quote -> quote.getQuote())
                .collect(Collectors.toList());

    }
}
