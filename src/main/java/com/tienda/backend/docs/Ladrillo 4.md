### 🧱 JUEVES — Primer Mapa de Arquitectura

### 1️⃣ LA REGLA DE ORO: ¿Quién hace qué?

Para que tu sistema sea escalable y limpio, cada capa tiene una única responsabilidad. Así es como se divide tu tesis:

- **🖥️ Quién Muestra (Frontend / Angular):** Presenta la interfaz, lee los clics del usuario y dibuja las metáforas y el código. *No toma decisiones de negocio, solo obedece y muestra.*
- **🚚 Quién Transporta (DTOs / Controladores):** Son los "mensajeros". Llevan la información del Frontend al Backend y viceversa. Evitan que expongas tu base de datos directamente a internet.
- **🧠 Quién Decide (Backend Lógica / Spring Boot Services):** Aquí vive el "cerebro" de tu tesis. Recibe la respuesta del usuario, aplica patrones (como *Strategy* para evaluar), decide si es correcta y genera la retroalimentación.
- **💾 Quién Guarda (Backend Persistencia / Repositorios y Base de Datos):** Escribe y lee la información de manera segura en la base de datos (SQL/Cosmos DB).

---

### 2️⃣ MAPA DE ENTIDADES (El Modelo de Dominio)

No todas las entidades están al mismo nivel. Vamos a agruparlas lógicamente para que tu base de datos tenga sentido:

**👥 Módulo de Identidad:**

- **Usuario:** El estudiante que interactúa con el sistema.

**📚 Módulo de Contenido (Lo que enseñas):**

- **Tema:** Agrupador principal (ej. "Patrones de Creación").
- **Patrón de Diseño:** El concepto central (ej. "Factory", "Strategy").
- **Lección:** La unidad de aprendizaje que pertenece a un patrón. *Una lección contiene:*
    - **Metáfora:** La explicación abstracta (ej. "El adaptador de enchufes").
    - **Pseudocódigo:** La lógica pura sin lenguaje específico.
    - **Código:** La implementación técnica (ej. en Java).

**⚙️ Módulo de Interacción y Evaluación (Lo que mides):**

- **Respuesta:** La decisión que toma el usuario frente a un problema planteado en la lección.
- **Retroalimentación:** El mensaje que genera tu sistema para explicarle al usuario por qué su decisión fue correcta o incorrecta.
- **Progreso:** El registro histórico que suma las victorias del usuario.

---

### 3️⃣ EL FLUJO DE DATOS (El sistema en movimiento)

Imagina que un usuario entra a resolver un ejercicio sobre el patrón *Strategy*. Así fluye la información a través de tu arquitectura:

1. **UI (Muestra):** El Frontend pide la `Lección` al Backend y dibuja la `Metáfora` y el `Código` en pantalla.
2. **Usuario Actúa:** El estudiante elige un `Patrón de Diseño` como solución y hace clic en "Enviar".
3. **DTO (Transporta):** El Frontend empaqueta esa `Respuesta` y se la envía al Backend.
4. **Service (Decide):** El Backend recibe la `Respuesta`. Aquí entra la lógica de tu tesis: evalúa la decisión del estudiante, determina el resultado y elabora la `Retroalimentación`.
5. **Repository (Guarda):** El Backend actualiza el `Progreso` del `Usuario` y lo guarda en la base de datos.
6. **UI (Muestra):** El Backend devuelve la `Retroalimentación` al Frontend, y el estudiante ve en pantalla por qué su decisión fue buena o cómo puede mejorar.