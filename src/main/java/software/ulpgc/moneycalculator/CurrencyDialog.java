package software.ulpgc.moneycalculator;

import java.util.Currency;
import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency get();
}
