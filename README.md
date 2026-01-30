.

🧠 Mini Tienda – Backend Spring Boot (Aprendizaje Real)

Este repositorio representa mi primer backend real conectado a un frontend (Angular).
No es un proyecto “de copiar y pegar”, sino un laboratorio de comprensión:
cada parte existe para aprender cómo fluye una petición real.

🎯 Objetivo

Pasar de:

Angular → arrays locales → datos que se pierden


a:

Angular → HTTP → Spring Boot → memoria del servidor


Con el mínimo backend viable, sin bases de datos, sin seguridad, sin frameworks extra.

🏗️ Arquitectura mental (analogía)
Capa	Rol	Analogía
Controller	Recibe y responde	🧍 Mostrador
Service	Decide y gestiona	🧠 Gerente
Modelo	Forma del dato	📦 Caja
Angular	Cliente	👤 Cliente

Regla de oro:
El controller no piensa, solo transmite.
El service decide.

🔁 Flujo real

Angular hace una petición HTTP.

El Controller la recibe.

El Controller le pregunta al Service.

El Service devuelve datos o toma decisiones.

El Controller responde en JSON.

🧩 Qué incluye este backend

/ping → prueba de vida del servidor.

/productos → devuelve lista de productos.

/carrito (en memoria) → simula persistencia real.

Producto → modelo base (id, name, price).

Todo vive en memoria del servidor, sin base de datos aún.

🚫 Qué NO tiene (a propósito)

Bases de datos

Seguridad

JPA

Docker

Login

Microservicios

Porque ahora el objetivo es entender el flujo, no memorizar frameworks.

🧠 Principio que guía este proyecto

“Identifico dónde quiero estar, mido mi avance, y sé cuándo llegué.”

Lo que se mide, crece.

🏁 Resultado esperado

Ser capaz de explicar en voz alta:

Qué es un controller.

Qué es un service.

Cómo Angular habla con Spring.

Qué parte cambia si mañana uso una base de datos real.

🏷️ Estado del aprendizaje

 Controller responde

 Flujo HTTP real

 Separación de responsabilidades

 Persistencia real (futuro)

 Seguridad (futuro)
