package com.calculator.service;

import com.calculator.exception.CountryIsoCodeNotFoundException;
import com.calculator.repository.TaxRateProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxRateProviderServiceImpl implements TaxRateProviderService {
    @Autowired
    private TaxRateProviderRepository taxRateProviderRepository;

    @Override
    public Double getTaxRateByIso( String Iso) {

        Double taxRate = taxRateProviderRepository.getTaxRateByIso(Iso);
        if(taxRate != null) {
             return taxRate;
        }
        throw new CountryIsoCodeNotFoundException("ISO Code Not Found");
    }
}
