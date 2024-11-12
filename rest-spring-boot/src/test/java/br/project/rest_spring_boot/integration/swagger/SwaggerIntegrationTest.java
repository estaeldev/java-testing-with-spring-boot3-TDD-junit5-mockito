package br.project.rest_spring_boot.integration.swagger;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.project.rest_spring_boot.config.TestConfig;
import br.project.rest_spring_boot.integration.container.AbstractIntegrationTest;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {
    
    @Test
    public void testShouldDisplaySwaggerUIPage() {

        String content = RestAssured
            .given()
                .basePath("/swagger-ui/index.html")
                .port(TestConfig.SERVER_PORT)
            .when()
                .get()
                .then().statusCode(200)
                .extract().body().asString();

        System.out.println(content);
        
        Assertions.assertTrue(content.contains("Swagger UI"));
    }

}
