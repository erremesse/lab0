# lab1

## Comentarios:
Modificaciones del proyecto original:
I. TwitterLookupService: para cada nueva búsqueda se crea un stream que es procesado por un callback cada vez que llega un nuevo registro.
	SimpleStreamListener: procesa cada nuevo tweet, enviando a la cola de salida la información.
	
II. WebSocketConfig: Configuración servidor mensajería para usar STOMP sobre Websockets. Se crea el endpoint (donde tenemos nuestro cliente SOCKJS) y los prefijos a usar por las diferentes partes de la app.

III. Implementación envío/recepción de mensajes: 
	Index.html -> functions.js: Necesario conectar con sistemas mensajería (connect) y suscribirse a un canal cuando tenemos el evento de búsqueda de la interfaz (send y suscribe).
Send -> Envio mensaje al interfaz Search de la app
Suscribe -> Esperar resultados (tweets) para incluirlos en la interfaz mediante plantilla de Moustache.


PROBLEMA: Los mensajes están llegando correctamente al receptor, pero la plantilla de Mustache no está funcionando adecuadamente y no se muestran los tweets.
