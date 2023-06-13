package me.geuxy.passwordgen.gui;

import me.geuxy.passwordgen.gui.components.Button;
import me.geuxy.passwordgen.gui.components.CheckBox;
import me.geuxy.passwordgen.gui.components.Label;
import org.apache.commons.lang3.RandomStringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Window extends JFrame {
    private final CheckBox lowercase, uppercase, numbers, brackets, symbols, slashes;
    private final JSpinner passwordLength;
    private final Button generate, copy;
    private final Label result;

    public Window(String name, int width, int height) {

        // Setup window
        this.setTitle(name);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        // Add components
        this.add(new Label("Include:"));
        this.add(lowercase = new CheckBox("Lowercase letters"));
        this.add(uppercase = new CheckBox("Uppercase letters"));
        this.add(numbers = new CheckBox("Numbers"));
        this.add(brackets = new CheckBox("Brackets"));
        this.add(symbols = new CheckBox("Symbols"));
        this.add(slashes = new CheckBox("Slashes"));

        this.add(new Label("Password Length:"));
        this.add(passwordLength = new JSpinner(new SpinnerNumberModel(12, 6, 30, 1)));

        this.add(new Label("Result:"));
        this.add(result = new Label("Waiting..."));
        this.add(generate = new Button("Generate"));
        this.add(copy = new Button("Copy to Clipboard"));

        // Add Action Listeners
        this.generate.addActionListener(listener -> {
            try {
                result.setText(RandomStringUtils.random((int) passwordLength.getValue(), this.getRandomString()));
            } catch(Exception e) {
                result.setText("Please select atleast 1 option");
            }
        });

        this.copy.addActionListener(listener -> {
            StringSelection selection = new StringSelection(result.getText());

            if(!result.getText().contains("Waiting...") && !result.getText().contains("Please select")) {
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
            }
        });

        // Setup layout
        GridLayout layout = new GridLayout(this.getComponents().length - 1, 1);
        layout.setHgap(4);
        layout.setVgap(4);

        this.setLayout(layout);
        this.setVisible(true);
    }

    // Generates a random string with the selected options
    private String getRandomString() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz", chars = "";

        if(lowercase.isSelected()) {
            chars += alphabet;
        }

        if(uppercase.isSelected()) {
            chars += alphabet.toUpperCase();
        }

        if(numbers.isSelected()) {
            chars += "0123456789";
        }

        if(brackets.isSelected()) {
            chars += "[]{}()";
        }

        if(symbols.isSelected()) {
            chars += "!@#$%^&*_+-=";
        }

        if(slashes.isSelected()) {
            chars += "/\\";
        }

        return RandomStringUtils.random((int) passwordLength.getValue(), chars);
    }

}
