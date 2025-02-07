package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Complex Number Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ComplexNumberCalculator());
            frame.pack();
            frame.setSize(765,400);
            frame.setVisible(true);
        });
    }
}
