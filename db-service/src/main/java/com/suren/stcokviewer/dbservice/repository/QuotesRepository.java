package com.suren.stcokviewer.dbservice.repository;

import com.suren.stcokviewer.dbservice.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Surendirababu Janarthanan on 8/13/2017.
 */
@Repository
public interface QuotesRepository extends JpaRepository<Quote,Integer> {

    public List<Quote> findByUserName(String userName);
}

