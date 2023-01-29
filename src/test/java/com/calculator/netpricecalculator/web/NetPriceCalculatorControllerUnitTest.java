package com.calculator.netpricecalculator.web;
import com.calculator.service.NetPriceCalculatorService;
import com.calculator.web.NetPriceCalculatorController;
import org.junit.runner.RunWith;
import org.junit.Test;

import com.calculator.NetPriceCalculatorApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@WebMvcTest(NetPriceCalculatorController.class)
public class NetPriceCalculatorControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    NetPriceCalculatorService netPriceCalculatorService;

    @Test
    public void getNetPrice() throws Exception {
         mockMvc.perform(get("/calculator/netprice?grossPrice=200.50&countryIso=DE"))
                 .andExpect(status().isOk());
        verify(netPriceCalculatorService, times(1)).computeNetPrice(200.50, "DE");
    }


}
