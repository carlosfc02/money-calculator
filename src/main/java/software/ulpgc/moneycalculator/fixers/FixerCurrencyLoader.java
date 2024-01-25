package software.ulpgc.moneycalculator.fixers;

import software.ulpgc.moneycalculator.Currency;
import software.ulpgc.moneycalculator.CurrencyLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static java.util.Collections.emptyList;

public class FixerCurrencyLoader implements CurrencyLoader {
    @Override
    public List<Currency> load() {
        try{
            return toList(loadJson())
        } catch (IOException E) {
            return emptyList();
        }
    }

    private List<Currency> toList(String json) {
        List<Currency> list = new ArrayList<>();
        Map<String, JsonElemet>
    }
}
