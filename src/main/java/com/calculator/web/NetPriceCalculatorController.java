package com.calculator.web;

import com.calculator.entity.PriceDetails;
import com.calculator.exception.CountryIsoCodeNotFoundException;
import com.calculator.service.NetPriceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/calculator")
public class NetPriceCalculatorController {

    @Autowired
    private NetPriceCalculatorService netPriceCalculatorService;

    @GetMapping("/netprice")
    public ResponseEntity<PriceDetails> getNetPrice(@RequestParam("grossPrice") double grossPrice, @RequestParam("countryIso") String countryIso) {
        try {
           return new ResponseEntity<PriceDetails>(netPriceCalculatorService.computeNetPrice(grossPrice, countryIso), HttpStatus.OK);
        } catch(CountryIsoCodeNotFoundException exp) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country ISO Not Found");
        }
    }

}
