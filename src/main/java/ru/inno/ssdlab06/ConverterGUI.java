package ru.inno.ssdlab06;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConverterGUI {
    JFrame frame;
    JTextField originalAmountField;
    JTextField convertedAmountField;
    JComboBox<String> originalCurrencyBox;
    JComboBox<String> newCurrencyBox;
    JButton swapButton;
    JButton convertButton;
    CurrencyConverter converter;
    public ConverterGUI(){
        ActionListener convertActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        };
        converter = new CurrencyConverter();
        String[] availableCurrencies = converter.listAvailableCurrencies();
        frame = new JFrame("Currency converter");
        frame.setSize(300, 100);
        originalAmountField = new JTextField();
        originalAmountField.setBounds(10, 10, 80, 20);
        originalAmountField.addActionListener(convertActionListener);
        originalCurrencyBox = new JComboBox<>(availableCurrencies);
        originalCurrencyBox.setBounds(10, 40, 80, 20);
        originalCurrencyBox.addActionListener(convertActionListener);
        convertButton = new JButton("Convert");
        convertButton.setBounds(100, 10, 80, 20);
        convertButton.addActionListener(convertActionListener);
        swapButton = new JButton("Swap");
        swapButton.setBounds(100, 40, 80, 20);
        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swap();
            }
        });
        convertedAmountField = new JTextField();
        convertedAmountField.setBounds(190, 10, 80, 20);
        convertedAmountField.addActionListener(convertActionListener);
        newCurrencyBox = new JComboBox<>(availableCurrencies);
        newCurrencyBox.setBounds(190, 40, 80, 20);
        newCurrencyBox.setEditable(false);
        frame.setLayout(null);
        frame.add(originalAmountField);
        frame.add(originalCurrencyBox);
        frame.add(convertButton);
        frame.add(swapButton);
        frame.add(convertedAmountField);
        frame.add(newCurrencyBox);
        frame.setVisible(true);
    }
    private void convert(){
        try{
            float originalAmount = Float.parseFloat(originalAmountField.getText());
            String originalCurrency = (String) originalCurrencyBox.getSelectedItem();
            String newCurrency = (String) newCurrencyBox.getSelectedItem();
            Float convertedAmount = converter.convert(originalAmount, newCurrency, originalCurrency);
            convertedAmountField.setText(convertedAmount.toString());
        }
        catch(NumberFormatException e){
            convertedAmountField.setText("Error");
        }
    }
    private void swap(){
        int temp = originalCurrencyBox.getSelectedIndex();
        originalCurrencyBox.setSelectedIndex(newCurrencyBox.getSelectedIndex());
        newCurrencyBox.setSelectedIndex(temp);
    }
}
