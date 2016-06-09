package es.unizar.tmdad.lab0.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Stream;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

@Service
public class TwitterLookupService {
	@Value("${twitter.consumerKey}")
	private String consumerKey;
	
	@Value("${twitter.consumerSecret}")
	private String consumerSecret;
	
	@Value("${twitter.accessToken}")
	private String accessToken;
	
	@Value("${twitter.accessTokenSecret}")
	private String accessTokenSecret;
	
	@Autowired
	SimpMessageSendingOperations messagingTemplate;
	
	private Map<String, Stream> streams = new HashMap<>();
	
	public void search(String query) {
		if(!streams.containsKey(query) && streams.size()<=10){
			 Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		     List<StreamListener> listeners = new ArrayList<>();
		     listeners.add(new SimpleStreamListener(messagingTemplate, query)); //Listener/Callback, especifica que tiene que hacer con cada tweet
		        
		     Stream stream = twitter.streamingOperations().filter(query, listeners); //Monitoriza un stream filtrado, dada una lista de "listeners" que monitorizar.
		     streams.put(query, stream);
		}
       
    }
}
