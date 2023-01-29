package com.calculator.netpricecalculator.web;

import com.calculator.entity.PriceDetails;
import com.calculator.web.NetPriceCalculatorController;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NetPriceCalculatorControllerIntegrationTest {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getNetPriceForValidInputs() throws Exception {
        ResponseEntity<PriceDetails> response = this.testRestTemplate.getForEntity("http://localhost:" + port + "/calculator/netprice?grossPrice=200.50&countryIso=DE", PriceDetails.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getNetPrice(), equalTo(162.405));
    }

    @Test
    public void getNetPriceForInValidInputs() throws Exception {
        ResponseEntity<PriceDetails> response = this.testRestTemplate.getForEntity("http://localhost:" + port + "/calculator/netprice?grossPrice=200.50&countryIso=DE1", PriceDetails.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }
}
