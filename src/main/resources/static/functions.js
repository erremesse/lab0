$(document).ready(function() {
	registerSearch();
});

var stompClient = null;
var isSuscript = 0;
var subscription = null;

function registerSearch() {
	connect();
	$("#search").submit(function(ev){
		event.preventDefault();
		suscribe();	
	});
}

function connect() {
    var socket = new SockJS('/twitter');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
    console.log('Connected: ' + frame);
    });
}

function suscribe() {
	var query = $("#q").val();
	if(isSuscript == 1){
		subscription.unsubscribe();
	} 
	$("#resultsBlock").empty();
	stompClient.send("/app/search", {}, query);
	subscription = stompClient.subscribe('/queue/search/'+$("#q").val(), function(data){
		var template = $('#template').html();
		
		//var html = Mustache.to_html(template,JSON.parse(data.body));
		var html = Mustache.render(template, data);
		$("#resultsBlock").prepend(html);
		array = $("#resultsBlock").children();
		if(array.length > 10){
			array[array.length-1].remove();
		}		
    });
	isSuscript = 1;
}
