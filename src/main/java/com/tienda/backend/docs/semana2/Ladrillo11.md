🧱 TU LADRILLO DEL DÍA 11: Relaciones Parte 2 (Jerarquía del Contenido)
⏱️ 20 min — Capturar (Entender la "Cascada")

El concepto: Los datos de tu contenido no son planos; son como muñecas rusas (Matrioshkas). Un Tema (ej. Creacionales) contiene varios Patrones. Un Patron (ej. Factory) contiene Lecciones. Una Leccion contiene varias Opciones.

El problema: Si borras un "Patrón" de tu sistema porque quedó obsoleto, pero no borras sus "Lecciones" y "Opciones", dejas "datos fantasma" (huérfanos) ocupando espacio en tu base de datos y rompiendo la integridad.

⏱️ 40 min — Construir (Evaluar y Aplicar los Planos)
Mapea esto en tu diseño (Notion o papel) pensando en Spring Boot y SQL. La magia aquí se llama Borrado en Cascada (CascadeType.ALL).

Así se ven las conexiones de arriba hacia abajo:

De Tema a Patrón:

Un Tema tiene un @OneToMany hacia Patron.

De Patrón a Lección:

Un Patron tiene un @OneToMany (o @OneToOne si es una sola lección por patrón) hacia Leccion.

Regla de Hierro: Debe tener cascade = CascadeType.ALL, orphanRemoval = true. Si eliminas el patrón, la lección desaparece de la base de datos automáticamente.

De Lección a Opciones:

Una Leccion tiene un @OneToMany hacia OpcionRespuesta.

Regla de Hierro: También con borrado en cascada. Si borras la lección, no tiene sentido que sus botones (opciones) sigan existiendo.

⏱️ 20 min — Enseñar (Ficha + Voz Alta)
Ponte de pie. Aléjate de la pantalla. Imagina que tienes a un Junior enfrente y explícale cómo viaja esto al Frontend.
Tu guion de práctica: "El Frontend es tonto, no sabe armar relaciones. Por eso, mi Backend (Spring Boot) hace una sola consulta a la base de datos buscando la 'Lección'. Hibernate (el ORM) automáticamente jala todas las 'Opciones' que le pertenecen a esa lección, lo empaqueta todo en un solo DTO (un gran objeto JSON) y se lo manda al Frontend en un solo viaje. Así, Angular solo recibe el paquete y pinta los botones."

Vuelve a sentarte y llena tu plantilla: