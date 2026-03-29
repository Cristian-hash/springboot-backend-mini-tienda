# Día 19 — Autenticación (solo concepto)

## Qué entendí hoy

La autenticación sirve para responder: “¿quién eres?”
Login es la acción de entrar.
Auth es todo el mecanismo que verifica ese acceso y protege el sistema.

## Login vs Auth

- Login: el usuario intenta entrar
- Auth: el sistema verifica y permite o rechaza el acceso

## Session vs Token

### Session
Es un estado temporal guardado en el servidor.
Sirve para recordar que el usuario ya entró.

### Token
Es un pase digital que el frontend envía en cada petición.
El backend lo valida para permitir acceso.

## Qué problema resuelve auth

Autenticación permite:
- identificar usuarios
- proteger datos
- controlar accesos
- evitar que cualquiera use el sistema

## Regla de arquitectura

La seguridad vive en el backend.
El frontend solo transporta credenciales y muestra pantallas.