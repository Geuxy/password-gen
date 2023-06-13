package me.geuxy.passwordgen.gui.components;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(String text) {
        this.setText(text);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setBackground(Color.WHITE);
        this.setFocusPainted(false);
        this.setFont(new Font("Arial", Font.PLAIN, 14));

    }

}
