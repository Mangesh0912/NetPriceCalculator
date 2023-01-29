package com.calculator.service;

import com.calculator.entity.PriceDetails;

public interface NetPriceCalculatorService {

      PriceDetails computeNetPrice(Double grossPrice, String countryIso);

}
