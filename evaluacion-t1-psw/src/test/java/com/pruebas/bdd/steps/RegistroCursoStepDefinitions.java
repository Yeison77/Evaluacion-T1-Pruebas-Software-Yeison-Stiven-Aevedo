package com.pruebas.bdd.steps;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class RegistroCursoStepDefinitions {
    private Map<String, Object> curso;
    private Response respuesta;

    @Before
    public void configurar() { RestAssured.baseURI = "http://localhost"; RestAssured.port = 8080; }

    @Dado("que preparo un curso con nombre {string}, precio {double} y {int} vacantes")
    public void prepararCurso(String nombre, double precio, int vacantes) {
        curso = new HashMap<>(); curso.put("nombre", nombre); curso.put("precio", precio); curso.put("vacantes", vacantes);
    }

    @Cuando("envío la solicitud para registrar el curso")
    public void enviarSolicitud() {
        respuesta = given().contentType("application/json").body(curso).when().post("/api/cursos");
    }

    @Entonces("el servicio responde con código 200 y devuelve el nombre {string}")
    public void validarRegistro(String nombre) {
        assertEquals(200, respuesta.statusCode());
        assertEquals(nombre, respuesta.jsonPath().getString("nombre"));
    }

    @Entonces("el servicio rechaza la solicitud con un código de error")
    public void validarRechazo() {
        assertTrue(respuesta.statusCode() >= 400 && respuesta.statusCode() <= 599,
                "Se esperaba un estado HTTP 4xx o 5xx, pero se recibió " + respuesta.statusCode());
    }
}
