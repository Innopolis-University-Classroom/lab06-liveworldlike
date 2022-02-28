package ru.inno.ssdlab06;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private final Map<String, Float> converterMap = new HashMap<>();

    public CurrencyConverter() {
        getCurrencies();
    }

    public void getCurrencies() {
        converterMap.put("rouble", 0.15f);
        converterMap.put("usd", 1f);
        converterMap.put("eur", 1.13f);
        converterMap.put("jpy", 0.0086f);
        converterMap.put("gbp", 1.34f);
        converterMap.put("aud", 0.72f);
        converterMap.put("cad", 0.79f);
        converterMap.put("chf", 1.08f);
        converterMap.put("cny", 0.16f);
        converterMap.put("hkd", 0.13f);
    }

    public float convert(float amount, String newCurrency, String oldCurrency) {
        return amount * converterMap.get(oldCurrency) / converterMap.get(newCurrency);
    }

    public String[] listAvailableCurrencies() {
        String[] result = new String[converterMap.size()];
        int i = 0;
        for (String currency : converterMap.keySet()) {
            result[i] = currency;
            i++;
        }
        return result;
    }
}
