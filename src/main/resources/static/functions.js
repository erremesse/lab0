$(document).ready(function() {
	registerSearch();
});

function registerSearch() {
	$("#search").submit(function(ev){
		event.preventDefault();
		$.get($(this).attr('action'), {q: $("#q").val()}, function(data) {
			  var template = $('#template').html();
			  // Mustache.parse(template);   // optional, speeds up future uses
			  var rendered = Mustache.render(template, data); //Mustache.to_html(template, data)
			  $("#resultsBlock").empty().append(rendered);
		});	
	});
}
