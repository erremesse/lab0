# lab0

## URI Heroku:

(localhost:8080/index.html)


## Comentarios:
Modificaciones del proyecto original:
*SearchController -> 
	+ Transformar a RestController 
	+ Modificar método "search()" para que devuelva directamente los resultados de la query al API de Twitter (en JSON)
*index.html ->  
	+ Eliminar dependencias de Thymeleaf (es lo que reemplaza Mustache)
	+ Añadir dependencias de Mustache (mustache.js + template + modificar)
	+ Mover a /public (ya no se devuelve el recurso html completo, no será necesario "search.html")
*functions.js ->
	+ Cargar template y volcar datos