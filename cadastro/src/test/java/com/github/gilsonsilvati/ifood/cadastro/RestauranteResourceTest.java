package com.github.gilsonsilvati.ifood.cadastro;

import javax.ws.rs.core.Response.Status;

import org.approvaltests.Approvals;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.gilsonsilvati.ifood.cadastro.dto.AtualizarRestauranteDTO;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTest
@QuarkusTestResource(CadastroTestLifecycleManager.class)
public class RestauranteResourceTest {

    @Test
    @DataSet("restaurantes-cenario-1.yml")
    public void testBuscarRestaurantes() {
    	String resultado = given()
    			.when()
    				.get("/restaurantes")
    			.then()
    				.statusCode(Status.OK.getStatusCode())
    			.extract()
    				.asString();
    	
    	Approvals.verifyJson(resultado);
    }
    
    @Test
    @DataSet("restaurantes-cenario-1.yml")
    public void testAlterarRestaurantes() {
    	var dto = new AtualizarRestauranteDTO();
    	dto.nomeFantasia = "novoNome";
    	
    	Long parameterValue = 123L;
    	
    	given()
    			.with().pathParam("id", parameterValue)
    			.body(dto)
    			.when()
    				.put("/restaurantes/{id}")
    			.then()
    				.statusCode(Status.NO_CONTENT.getStatusCode())
    			.extract()
    				.asString();
    			
    	Restaurante findById = Restaurante.findById(parameterValue);
    	
    	// Poderia testar todos os outros atributos
    	Assert.assertEquals(dto.nomeFantasia, findById.nome);
    }
    
    private RequestSpecification given() {
    	return RestAssured.given().contentType(ContentType.JSON);
    }

}