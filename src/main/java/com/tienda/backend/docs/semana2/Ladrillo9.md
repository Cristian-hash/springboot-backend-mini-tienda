🧱 TU LADRILLO DEL DÍA 9: Entidades de Contenido (Patrón, Lección, Opción)
⏱️ 20 min — Capturar (Entender)


El concepto: El contenido de tu tesis (las metáforas, el pseudocódigo, los problemas) no se escribe directamente en las pantallas del Frontend; hacer eso sería hardcodear. Todo debe vivir en la base de datos para que tu sistema sea dinámico e inteligente.


El problema: Si no divides la lección exactamente en "casilleros" dentro de tu base de datos, el Backend no podrá empaquetar la información ordenada y el Frontend no sabrá qué pintar.

⏱️ 40 min — Evaluar y Aplicar (Construir)
Escribe en tu Notion los atributos para estas entidades. Observa cómo son el reflejo exacto de tu Ladrillo 5:

1. Entidad: Patron (El agrupador principal)

id (Long, Primary Key) -> Identificador único.

nombre (String) -> ej. "Strategy", "Backtracking".

tipo (String) -> ej. "Creacional", "Comportamiento", "Fundamento".


descripcion_corta (String) -> La definición de una línea.

2. Entidad: Leccion (Tu plantilla de 7 pasos hecha datos)

id (Long, Primary Key) -> El ticket de la lección.

patron_id (Long, Foreign Key) -> Relación Mucho-a-Uno. ¿A qué patrón pertenece?.


problema_hook (Text) -> El dolor inicial.

metafora (Text) -> Ej. El Sudoku o el Extintor.


pseudocodigo (Text) -> La lógica pura e independiente.


codigo_java (Text) -> La implementación técnica.


criterio_si (String) -> Regla de decisión: Cuándo usarlo.


criterio_no (String) -> Regla de decisión: Cuándo no usarlo.


ejercicio_planteado (Text) -> El caso real para que el alumno decida.

3. Entidad: OpcionRespuesta (Las alternativas para la evaluación)

id (Long, Primary Key) -> Identificador único.


leccion_id (Long, Foreign Key) -> Relación Mucho-a-Uno.

texto_opcion (String) -> Ej. "A) Usar Fuerza Bruta", "B) Usar Patrón Backtracking".


es_correcta (Boolean) -> True o False.


justificacion_feedback (Text) -> El mensaje que genera tu sistema para explicar la decisión.

⏱️ 20 min — Enseñar (Ficha + Voz Alta)
Ponte de pie. Imagina que el Ing. Jonathan te pregunta: "¿Cómo haces para agregar una nueva lección sin tener que programar otra pantalla?". Explícale tu arquitectura en voz alta usando esta ficha.