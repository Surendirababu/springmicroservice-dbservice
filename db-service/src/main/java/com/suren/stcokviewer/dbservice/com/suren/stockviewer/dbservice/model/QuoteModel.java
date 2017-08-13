package com.suren.stcokviewer.dbservice.com.suren.stockviewer.dbservice.model;

import java.util.List;

/**
 * Created by Surendirababu Janarthanan on 8/13/2017.
 */
public class QuoteModel {

    private String username;

    private List<String> quotename;

    public QuoteModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getQuotename() {
        return quotename;
    }

    public void setQuotename(List<String> quotename) {
        this.quotename = quotename;
    }
}
