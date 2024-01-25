package software.ulpgc.moneycalculator;

import java.util.Currency;
import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
