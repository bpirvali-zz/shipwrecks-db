package com.bp.springboot.samples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by behzad.pirvali on 11/20/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ShipwrecksControllerIntegTest {

    @Test
    public void testListAll() throws InterruptedException {
        TestRestTemplate svc = new TestRestTemplate();
        ResponseEntity<String> entity = svc.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
        String body = entity.getBody();
        assertTrue(entity.getStatusCode()== HttpStatus.OK);
        assertTrue(body.startsWith("[") && body.endsWith("]"));
    }
}
