package com.calculator.service;

import com.calculator.entity.PriceDetails;
import com.calculator.exception.CountryIsoCodeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetPriceCalculatorServiceImpl implements  NetPriceCalculatorService{

    @Autowired
    private TaxRateProviderService taxRateProviderService;

    @Override
    public PriceDetails computeNetPrice(Double grossPrice, String countryIso) {
      try {
          double taxRate = taxRateProviderService.getTaxRateByIso(countryIso);
          double taxesOwed = grossPrice * taxRate;
          double netPrice = grossPrice - taxesOwed;
          return new PriceDetails((netPrice));
      } catch(CountryIsoCodeNotFoundException ex) {
            throw ex;
      }catch(Exception ex) {
          System.out.println("Exception is:"+ ex.getMessage());
          throw ex;
      }
    }
}
