🧱 TU LADRILLO DEL DÍA 8: Entidades Base (Identidad y Progreso Avanzado)
Hoy nos enfocamos en la "despensa" de tu sistema. Vamos a definir las verdades inmutables (las tablas SQL) aplicando la normalización de base de datos para que tu plataforma pueda escalar a miles de usuarios sin colapsar.

Capturar (Entender a fondo)

El concepto: Una "Entidad" en Java (Spring Boot) es un espejo exacto de una tabla en tu base de datos relacional. Aquí no hay botones, colores ni flujos; solo hay datos crudos, tipos de variables y restricciones (Constraints) como "No Nulo" o "Único".

El problema: Si diseñas mal esto desde el día 1 (por ejemplo, guardando el puntaje total como un número fijo dentro de la tabla Usuario), tendrás un sistema rígido. Si el usuario reclama un punto, no sabrás de dónde salió. Necesitamos un registro histórico inmutable.

SEvaluar y Aplicar (Construir los Planos Exactos)
Aquí están los atributos detallados. Fíjate en los tipos de datos y las restricciones de ingeniería:

1. Entidad: Usuario (Módulo de Identidad)


id (Long, Primary Key, Autogenerado) -> El identificador único e inmutable en el sistema.

email (String, Único, Not Null) -> Se usa como credencial de acceso. La base de datos debe rechazar duplicados.


password (String, Not Null) -> Ojo: Aquí nunca se guarda la contraseña real, se guarda el hash encriptado (ej. usando BCrypt).

rol (String) -> Por defecto será "ESTUDIANTE". (Útil a futuro si agregas un rol "ADMIN") .

fecha_registro (LocalDateTime, Updatable = false) -> Para auditoría. Saber exactamente cuándo entró por primera vez.

2. Entidad: Progreso (Módulo de Interacción - Versión Analítica)


id (Long, Primary Key, Autogenerado) -> El "ticket" único de este intento.

usuario_id (Long, Foreign Key) -> Relación Mucho-a-Uno. ¿Quién hizo el intento?

leccion_id (Long, Foreign Key) -> Relación Mucho-a-Uno. ¿Qué lección específica estaba resolviendo?

decision_correcta (Boolean) -> Lectura rápida: ¿Acertó el patrón o no? (True/False) .

opcion_elegida_id (Long, Foreign Key) -> ¡Tu mejora analítica! Guardamos exactamente qué botón presionó. Si falló porque eligió "Fuerza Bruta" en lugar de "Backtracking", el sistema lo recordará para la futura extensión de IA.


fecha_intento (LocalDateTime, Updatable = false) -> Cuándo ocurrió exactamente la interacción.