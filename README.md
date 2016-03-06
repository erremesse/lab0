# lab0

## URI Heroku:
https://fierce-meadow-22677.herokuapp.com/

## Comentarios:
Modificaciones del proyecto original:
* SearchController -> 
	+ Transformar a RestController 
	+ Eliminar mapeo a "/"
	+ Modificar método "search()" para que devuelva directamente los resultados de la query al API de Twitter (en JSON)
* index.html ->  
	+ Eliminar dependencias de Thymeleaf (es lo que reemplaza Mustache)
	+ Añadir dependencias de Mustache (mustache.js + template + modificar)
	+ Mover a /public (ya no se devuelve el recurso html completo, no será necesario "search.html")
	+ Cuidado! jQuery y Bootstrap hand e ser cargados via *https*
* functions.js ->
	+ Cargar template y volcar datos
	
(LogoUZ no se muestra adecuadamente)
(Template no carga correctamente en FIREFOX)
