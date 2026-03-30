# 🧱 Día 21 — Aprendizaje clave: JWT (sin miedo)

## 🧠 Qué entendí hoy (explicado simple)

Un token es como una credencial digital que dice quién eres.

JWT (JSON Web Token) es un tipo de token que el backend crea cuando haces login, y luego lo usas para demostrar tu identidad en cada petición.

Es como una pulsera en un evento:
no tienes que mostrar tu DNI cada vez, la pulsera ya dice que entraste.

---

## ⚙️ Cómo funciona (paso a paso real)

1. El usuario hace login
2. El backend verifica sus datos
3. El backend crea un token (JWT)
4. El frontend guarda ese token
5. En cada petición, el frontend envía el token
6. El backend valida el token
7. Si es válido → permite acceso

---

## 🧱 Regla de oro del día

👉 El token no da acceso, el backend decide si confiar en él.

---

## ❌ Qué pensaba antes

Pensaba que JWT era algo complejo o mágico.

También pensaba que el token “hacía la seguridad por sí solo”.

---

## ✅ Qué entiendo ahora

JWT es solo un paquete de información firmado.

La seguridad está en:
- quién lo crea (backend)
- quién lo valida (backend)

---

## 🔥 Diferencia clave

Antes:
JWT = magia / complicado

Ahora:
JWT = un mensaje firmado que el backend puede verificar

---

## 🎯 Ejemplo que puedo explicar

Es como un boleto de cine:

- El cine (backend) lo crea
- Tú lo llevas (frontend)
- El cine lo revisa cada vez que entras

El boleto no decide, el cine decide si es válido.

---

## 🧠 Dónde vive cada cosa (ARQUITECTURA)

- Lógica (quién decide):
  Backend (valida el token)

- Ejecución (quién verifica):
  Backend (decodifica y valida firma)

- Persistencia (quién guarda):
  Base de datos (usuarios, no el token)

- Transporte (quién solo pasa datos):
  Frontend (envía token en cada request)

---

## 🧠 Frase ancla

👉 “JWT no es seguridad, es una prueba que el backend decide aceptar.”

---

## 🚀 Cómo sé que lo entendí

Porque puedo explicar:

- qué es un token sin usar palabras complejas
- por qué el frontend no decide nada
- por qué el backend siempre valida
- que JWT no es magia, es un objeto firmado