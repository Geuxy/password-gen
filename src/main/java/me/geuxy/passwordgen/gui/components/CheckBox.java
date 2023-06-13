package me.geuxy.passwordgen.gui.components;

import javax.swing.*;
import java.awt.*;

public class CheckBox extends JCheckBox {

    public CheckBox(String text) {
        this.setText(text);
        this.setFocusPainted(false);
        this.setBorder(null);
        this.setFont(new Font("Arial", Font.PLAIN, 14));

    }

}
