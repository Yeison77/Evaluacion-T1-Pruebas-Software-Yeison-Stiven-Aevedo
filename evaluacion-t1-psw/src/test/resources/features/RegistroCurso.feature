# language: es
Característica: Registro de cursos
  Como administrador académico
  Quiero registrar cursos
  Para mantener actualizada la oferta académica

  Escenario: Registro de curso válido
    Dado que preparo un curso con nombre "Selenium Avanzado", precio 400.0 y 20 vacantes
    Cuando envío la solicitud para registrar el curso
    Entonces el servicio responde con código 200 y devuelve el nombre "Selenium Avanzado"

  Escenario: Registro con precio inválido
    Dado que preparo un curso con nombre "Curso inválido", precio 0.0 y 20 vacantes
    Cuando envío la solicitud para registrar el curso
    Entonces el servicio rechaza la solicitud con un código de error
