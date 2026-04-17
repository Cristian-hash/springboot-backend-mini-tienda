🧱 TU LADRILLO DEL DÍA 12: Flujo de Usuario (El Viaje de los Datos)
⏱️ 20 min — Capturar (Entender el Flujo)

El concepto: Un "Diagrama de Secuencia" o "Flujo de Datos" no dibuja pantallas; dibuja el viaje del mensajero. Imagina que la información es un paquete de Amazon que pasa por diferentes aduanas.

El problema: Si no tienes claro este camino, terminarás metiendo lógica de evaluación en el Frontend (lo cual es un riesgo de seguridad) o haciendo que la base de datos hable directamente con la pantalla (lo cual rompe tu arquitectura limpia).

⏱️ 40 min — Construir (Mapear el "Happy Path")
El Happy Path (Camino Feliz) es el escenario donde el usuario hace todo bien y no hay errores de sistema. Mapea esta secuencia exacta en tu Notion, entendiendo qué hace cada capa:

(UI) Petición inicial: El usuario entra a la plataforma y hace clic en "Aprender Patrón Strategy". Angular (Frontend) hace una petición HTTP GET al Backend.

(Service + DB) Preparación de Lección: El Backend (Spring Boot) va a la Base de Datos, saca los textos de la lección y sus opciones, pero oculta cuál es la correcta.

(DTO) Transporte de ida: El Backend empaqueta todo en un JSON (DTO) y se lo manda al Frontend.

(UI) Interacción ciega: El Frontend dibuja la metáfora y el código. El usuario lee y elige la "Opción B". Angular captura el ID de esa opción, lo mete en un DTO y lo envía de regreso con un POST. Angular no sabe si es correcto o no.

(Service) El Cerebro Evalúa: El Backend recibe el opcion_id. Busca en la Base de Datos si esa opción tiene es_correcta == true. Determina que sí y prepara el mensaje de retroalimentación.

(DB) Persistencia: El Backend crea un registro en la tabla Progreso conectando el ID del usuario con el ID de la lección y el resultado. Lo guarda.

(UI) Muestra Feedback: El Backend envía el mensaje de retroalimentación en un nuevo DTO. Angular lo recibe y pinta un cuadro verde diciendo: "¡Correcto! Usaste Strategy para evitar Ifs gigantes".

⏱️ 20 min — Enseñar (Ficha + Voz Alta)
Ponte de pie, aléjate del monitor. Imagina que tienes a un Junior enfrente y verbaliza el viaje del DTO. Haz mucho énfasis en por qué el Frontend es completamente ciego a las decisiones lógicas. Luego, siéntate y llena tu plantilla: