package com.calculator.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TaxRateProviderRepositoryImpl implements TaxRateProviderRepository {
    Map<String, Double> taxRateProviderMap = new HashMap<String, Double>();

    TaxRateProviderRepositoryImpl() {
        populateTaxRates();
    }
    public void populateTaxRates() {
         taxRateProviderMap.put("DE", 0.19);
         taxRateProviderMap.put("FR", 0.20);
         taxRateProviderMap.put("AT", 0.20);
         taxRateProviderMap.put("PL", 0.23);
         taxRateProviderMap.put("HU", 0.27);
         taxRateProviderMap.put("GB", 0.20);
         taxRateProviderMap.put("CA", 0.05);
         taxRateProviderMap.put("IN", 0.18);
    }

    @Override
    public Double getTaxRateByIso(String Iso) {
        return taxRateProviderMap.get(Iso);
    }
}
