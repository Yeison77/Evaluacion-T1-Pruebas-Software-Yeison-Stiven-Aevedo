# Evaluación T1 – Pruebas de Software (2424)

Proyecto base: matrícula de cursos (Spring Boot 4.1.0, Java 17, Maven). Base de datos **H2 en memoria**: no necesitas instalar MySQL.

## Cómo ejecutar
1. Abrir la carpeta en IntelliJ IDEA (Open → seleccionar `pom.xml` → Open as Project) y esperar a que Maven descargue las dependencias.
2. Usar **JDK 17** (File → Project Structure → Project SDK).
3. Ejecutar `ModeloT1PswApplication` (la aplicación queda en http://localhost:8080). Los datos de prueba se cargan solos (`config/DataLoader`).
4. Con la aplicación encendida, ejecutar las pruebas de las preguntas 2 y 3. La pregunta 1 (Mockito) no necesita la aplicación encendida.

## Dónde crear tus archivos
- Pregunta 1: `src/test/java/com/pruebas/service/`
- Pregunta 2: `src/test/java/com/pruebas/api/`
- Pregunta 3: `src/test/resources/features/*.feature`, `src/test/java/com/pruebas/bdd/steps/*StepDefinitions.java` y una clase runner en `src/test/java/com/pruebas/bdd/`.

El `pom.xml` ya incluye JUnit 5, Mockito, Rest Assured y Cucumber.

## Pruebas implementadas para T1
- `src/test/java/com/pruebas/service/InscripcionServiceTest.java`: tres pruebas con Mockito (registro exitoso, duplicado y cancelación).
- `src/test/java/com/pruebas/api/CursoApiTest.java`: consulta de todos los cursos y consulta por ID.
- `src/test/resources/features/RegistroCurso.feature`: escenarios BDD de registro válido e inválido.
- `src/test/java/com/pruebas/bdd/steps/RegistroCursoStepDefinitions.java`: definiciones de pasos.
- `src/test/java/com/pruebas/bdd/RunCucumberTest.java`: ejecutor de Cucumber.

## Ejecución y capturas
1. Abrir el proyecto en IntelliJ IDEA y seleccionar JDK 17 (el entorno de ejecución debe tener Java 17).
2. Esperar que Maven descargue todas las dependencias.
3. Ejecutar `InscripcionServiceTest` directamente. Tomar captura donde se vean los 3 tests exitosos.
4. Iniciar `ModeloT1PswApplication` y esperar que Spring indique que inició en el puerto 8080.
5. Ejecutar `CursoApiTest` y `RunCucumberTest` con la aplicación levantada. Tomar capturas del panel de pruebas mostrando los resultados.

**Observación sobre el enunciado:** la hoja de evaluación solicita que `/api/cursos/1` devuelva "Seguridad de Aplicaciones". Sin embargo, el `DataLoader.java` del proyecto base indica expresamente que el ID 1 es "Pruebas de Software" y el ID 2 es "Seguridad de Aplicaciones". Para no alterar el cargador de datos original, la prueba comprueba el dato que realmente genera el proyecto base. Si el docente exige literalmente ID 1 = Seguridad de Aplicaciones, debe confirmar si autoriza cambiar el orden de carga.
