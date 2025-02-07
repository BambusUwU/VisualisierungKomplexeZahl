package org.example;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    public TopPanel() {
        JLabel placeholderLabel = new JLabel("Placeholder Text");
        setLayout(new BorderLayout());
        add(placeholderLabel, BorderLayout.CENTER);
    }
}