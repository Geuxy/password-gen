package me.geuxy.passwordgen.gui.components;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    public Label(String text) {
        this.setText(text);
        this.setFont(new Font("Arial", Font.BOLD, 14));
    }

}
