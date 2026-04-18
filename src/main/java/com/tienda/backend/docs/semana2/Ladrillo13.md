🧱 TU LADRILLO DEL DÍA 13: Reglas (El Cerebro Evaluador)
⏱️ 20 min — Capturar (Entender la "Lógica de Negocio")

El concepto: La "Lógica de Negocio" son las reglas de oro de tu sistema. No tiene nada que ver con mostrar botones (Frontend) ni con guardar filas (Base de datos). Es el proceso de pensar: "Si el usuario elige X, entonces pasa Y". En Spring Boot, este cerebro vive exclusivamente en las clases anotadas con @Service.

El problema: Si pones estas reglas en el Controlador (quien solo debe recibir peticiones) o en el Frontend, tu código se vuelve inseguro, difícil de leer y casi imposible de probar.

⏱️ 40 min — Construir (El Pseudocódigo del Evaluador)
Toma tu Notion o tu editor de código y escribe este flujo. Este es el método exacto que evaluará a tus estudiantes:

Java
// Pseudocódigo de tu EvaluacionService
public String evaluarRespuesta(Long usuarioId, Long opcionElegidaId) {

    // 1. Ir a la despensa (DB) y traer la opción que el usuario eligió
    OpcionRespuesta opcion = opcionRepository.findById(opcionElegidaId);
    
    // 2. Traer al usuario para enlazarlo
    Usuario usuario = usuarioRepository.findById(usuarioId);
    
    // 3. Crear el "Ticket" histórico en blanco
    Progreso nuevoProgreso = new Progreso();
    nuevoProgreso.setUsuario(usuario);
    nuevoProgreso.setLeccion(opcion.getLeccion());
    nuevoProgreso.setOpcionElegida(opcion);
    nuevoProgreso.setFechaIntento(LocalDateTime.now());
    
    // 4. EL CEREBRO EVALÚA (Lógica de Negocio)
    if (opcion.getEsCorrecta() == true) {
        nuevoProgreso.setDecisionCorrecta(true);
    } else {
        nuevoProgreso.setDecisionCorrecta(false);
    }
    
    // 5. Mandar a guardar la bitácora inmutable
    progresoRepository.save(nuevoProgreso);
    
    // 6. Retornar solo el feedback (el "por qué") para que el Controller se lo mande al Frontend
    return opcion.getJustificacionFeedback();
}
⏱️ 20 min — Enseñar (Ficha + Voz Alta)
Ponte de pie. Imagina que un Junior te propone mandar la respuesta correcta oculta al Frontend y que Angular haga el if (opcionElegida == respuestaCorrecta).

Tu guion en voz alta: "¡No podemos hacer eso! El Frontend se ejecuta en el navegador del usuario. Es territorio enemigo. Si le mandamos la respuesta correcta, cualquier estudiante puede presionar F12, abrir la consola, ver cuál es la opción ganadora y hackear la tesis. Por eso, el Frontend solo nos manda el ID del botón que presionó, y mi Backend (que está seguro en el servidor) es el único que tiene el poder de comparar ese ID con la verdad absoluta de la base de datos."