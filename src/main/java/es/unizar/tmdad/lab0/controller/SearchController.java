package es.unizar.tmdad.lab0.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

import es.unizar.tmdad.lab0.service.TwitterLookupService;


@RestController //Controller -> RestController
public class SearchController {

    @Autowired
    TwitterLookupService twitter;

    @MessageMapping("/search")
    public void search(String query){
    	twitter.search(query); 
    }
}