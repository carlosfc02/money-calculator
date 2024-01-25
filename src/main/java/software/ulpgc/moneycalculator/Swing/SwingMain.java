package software.ulpgc.moneycalculator.Swing;

import software.ulpgc.moneycalculator.*;
import software.ulpgc.moneycalculator.fixers.FixerCurrencyLoader;
import software.ulpgc.moneycalculator.fixers.FixerExchangeRateLoader;
import software.ulpgc.moneycalculator.mocks.MockExchangeRateLoader;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingMain extends JFrame {
    private final Map<String,Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                new FixerExchangeRateLoader(),
                main.moneyDisplay()
        );
        main.add("exchange money", command);
        main.setVisible(true);
    }

    private void add(String name, Command command) {
        commands.put(name,command);
    }

    private MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    private MoneyDialog moneyDialog() {
        return moneyDialog;
    }

    private CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    public SwingMain() throws HeadlessException{
        this.setTitle("Money calculator");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(createMoneyDialog());
        this.add(createCurrenxcyDialog());
        this.add(createMoneyDisplay());
        this.add(toolbar());
    }

    private Component toolbar() {
        JButton button = new JButton("calculate");
        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return  display;
    }

    private Component createCurrenxcyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }


}
