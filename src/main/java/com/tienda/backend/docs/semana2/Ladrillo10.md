🧱 TU LADRILLO DEL DÍA 10: Relaciones Parte 1 (El Historial del Usuario)
Hoy conectamos quién es el usuario con lo que hace, estableciendo la integridad referencial de tu sistema.

⏱️ 20 min — Capturar (Entender a fondo)


El concepto: Entender la relación "1 a Muchos" (1:N). Un usuario (1) puede tener múltiples intentos de lecciones (N), pero un intento de lección le pertenece estricta y únicamente a un solo usuario.


El problema: Si no usamos una relación formal, terminaríamos copiando el email, el nombre y la contraseña del usuario en cada fila de su historial. Esto rompe la normalización y hace que la base de datos sea un infierno de mantener.

⏱️ 40 min — Evaluar y Aplicar (Construir los Planos Exactos)
Mapeamos la conexión en tu diseño. En Spring Boot y SQL, esto se traduce así:


En la tabla Progreso: Llevará un campo llamado usuario_id. Este campo no es un simple número; es una Llave Foránea (Foreign Key). Es una restricción de hierro que le dice a la base de datos: "No me dejes insertar un progreso si el ID de este usuario no existe primero en la tabla Usuario".


En código Java (Spring Boot): * La entidad Progreso usará la anotación @ManyToOne y @JoinColumn(name = "usuario_id").

La entidad Usuario usará @OneToMany(mappedBy = "usuario").

⏱️ 20 min — Enseñar (Ficha + Voz Alta)
Ponte de pie, aplica el Proceso de Tres Personas. Imagina que tienes a un Junior enfrente y explícale cómo estas dos tablas se hablan sin mezclar sus datos. Luego, llena tu plantilla.



🛠️ PASO 1: Configurar la entidad Progreso (El lado "Muchos")El Progreso es el que "pertenece" a un Usuario. Por lo tanto, es en esta tabla donde físicamente va a existir la Llave Foránea (usuario_id).Así es como se escribe en Java usando Spring Boot:Javaimport jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "progreso")
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ... (aquí van tus otros campos: decision_correcta, fecha_intento, etc.)

    // 🔥 EL PUENTE DE ACERO: LA LLAVE FORÁNEA
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Getters y Setters...
}
🧠 ¿Qué está pasando aquí?@ManyToOne: Le dice a Spring Boot "Muchos registros de progreso pueden pertenecer a UN solo usuario".FetchType.LAZY: Es una buena práctica de rendimiento. Le dice al sistema que cuando busques un progreso, no cargue todos los datos del usuario a menos que se lo pidas explícitamente.@JoinColumn(name = "usuario_id", nullable = false): Crea la columna física en SQL. El nullable = false es la restricción de hierro: "Prohibido guardar un progreso si no tiene un usuario asignado".🛠️ PASO 2: Configurar la entidad Usuario (El lado "Uno")El Usuario es el "dueño" del historial. Él no guarda el ID del progreso; en su lugar, tiene una lista de todos los progresos que le pertenecen.Así se refleja en el código:Javaimport jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ... (aquí van tus campos: email, password, rol, etc.)

    // 🔥 EL REFLEJO DE LA RELACIÓN
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Progreso> historialProgresos = new ArrayList<>();

    // Getters y Setters...
}
🧠 ¿Qué está pasando aquí?@OneToMany: Le dice a Spring Boot "UN usuario tiene MUCHOS progresos".mappedBy = "usuario": Esto es vital. Le dice a Hibernate: "Yo no voy a crear una tabla intermedia para esta relación. El campo que controla esto se llama usuario y ya está definido en la clase Progreso".cascade = CascadeType.ALL y orphanRemoval = true: Reglas de negocio. Si eliminas a un usuario, su historial se elimina en cascada automáticamente para no dejar "datos huérfanos" (progresos fantasma) en la base de datos.🛠️ PASO 3: Visualizar la Tabla SQL Resultante (La Verdad Cruda)Cuando corras tu aplicación Spring Boot, Hibernate generará automáticamente la tabla progreso en tu base de datos (PostgreSQL/MySQL). Se verá exactamente así a nivel estructural:ColumnaTipo de DatoRestricción (Constraint)idLong (BigInt)PRIMARY KEY, AUTO_INCREMENTdecision_correctaBooleanNOT NULLfecha_intentoTimestampNOT NULLusuario_idLong (BigInt)FOREIGN KEY REFERENCES usuario(id)💡 El resultado: Ahora, si intentas guardar un progreso diciendo que pertenece al usuario_id = 999, pero ese 999 no existe en la tabla de Usuarios, la base de datos te lanzará un error de Integridad Referencial. Tu despensa de datos ahora es indestructible e inteligente.