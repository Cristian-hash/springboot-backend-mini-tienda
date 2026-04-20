LADRILLO DEL DÍA 15: Setup Base y Conexión DB (El Chasis del Sistema)
Hoy construimos el esqueleto de tu motor. No vamos a programar lógica de negocio todavía; vamos a asegurar que los cables de la batería estén bien conectados.

⏱️ 20 min — Capturar (Entender)
El concepto: Spring Initializr es la fábrica que te da el esqueleto del proyecto armado. El archivo application.properties (o .yml) es el panel de control donde tu Backend recibe las credenciales para hablar con la Base de Datos.

El problema: Si empiezas a crear clases sin antes asegurar que el servidor se puede comunicar con la base de datos (PostgreSQL/MySQL), estarás programando a ciegas.

⏱️ 40 min — Evaluar y Aplicar (Construir)
Abre tu navegador y tu IntelliJ IDEA, y ejecuta estos pasos de ingeniería:

Paso 1: Ve a Spring Initializr (start.spring.io) y genera un proyecto Maven/Gradle con Java 21. Agrega las dependencias clave: Spring Web, Spring Data JPA, y el Driver de tu Base de Datos (PostgreSQL o MySQL).

Paso 2: Abre el proyecto generado en tu IDE (IntelliJ o Eclipse). (¡Que ya tienes listo!)

Paso 3: Ve a src/main/resources/application.properties y escribe las credenciales de tu base de datos local (URL, usuario, contraseña) y configura spring.jpa.hibernate.ddl-auto=update.

Paso 4: Dale "Run" a tu aplicación. Si la consola muestra el logo de Spring y dice "Started Application in X seconds", ¡tu motor está vivo!

⏱️ 15 min — Enseñar (Ficha + Voz Alta)
Ponte de pie, aléjate del teclado y aplícate la "honestidad brutal".

Explícale a tu Junior imaginario: "Hoy no escribí algoritmos, hoy levanté la infraestructura de mi sistema. Configuré el puente seguro entre mi código Java 21 y mi base de datos. Sin esto, ningún patrón de diseño podría funcionar porque no tendríamos dónde guardar la información."

⏱️ 10 min — Commit
Guarda tu avance con un mensaje claro: init: setup proyecto spring boot base con java 21 y conexion db.