# Diseño de Usuario

## ¿Qué es un usuario?

Un usuario es una entidad que representa a una persona dentro del sistema.
No es solo un email, sino alguien con identidad propia que puede interactuar con la tienda.

---

## Datos que SÍ tendrá

- id
- nombre
- email

Opcionales:
- telefono
- direccion

---

## Datos que NO tendrá (por ahora)

- password
- roles
- permisos
- tokens

Estos se agregarán en la etapa de autenticación.

---

## Relación con Carrito

Un usuario tiene un carrito.

Usuario (1) ---- (1) Carrito

El carrito pertenece al usuario.

---

## Decisiones de arquitectura

- La lógica NO vive en Usuario
- Usuario solo representa datos
- El Service maneja reglas
- La base de datos es la fuente de verdad

---

## Nota importante

El diseño es simple a propósito para evitar complejidad prematura.