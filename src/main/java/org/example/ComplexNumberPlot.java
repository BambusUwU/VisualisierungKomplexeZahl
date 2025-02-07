package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplexNumberPlot extends JPanel {
    private double real;
    private double imaginary;
    private boolean showVector;

    public ComplexNumberPlot() {
        showVector = false; // Initial state: vector is not shown
    }

    public void plotComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        repaint();
    }

    public void toggleVector() {
        showVector = !showVector;
        repaint();
    }

    public boolean isShowVector() {
        return showVector;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int gridSize = 50;

        // Draw grid lines
        g.setColor(Color.LIGHT_GRAY);
        for (int x = centerX - gridSize; x <= width; x += gridSize) {
            g.drawLine(x, 0, x, height);
        }
        for (int x = centerX - gridSize; x >= 0; x -= gridSize) {
            g.drawLine(x, 0, x, height);
        }
        for (int y = centerY - gridSize; y <= height; y += gridSize) {
            g.drawLine(0, y, width, y);
        }
        for (int y = centerY - gridSize; y >= 0; y -= gridSize) {
            g.drawLine(0, y, width, y);
        }

        // Draw axes and labels
        g.setColor(Color.BLACK);
        g.drawLine(0, centerY, width, centerY);
        g.drawString("Re", width - 20, centerY + 20);
        g.drawLine(centerX, 0, centerX, height);
        g.drawString("Im", centerX + 10, 20);

        // Draw x-axis scale
        for (int i = -5; i <= 5; i++) {
            int x = centerX + i * gridSize;
            g.drawLine(x, centerY - 5, x, centerY + 5);
            if (i != 0) {
                g.drawString(Integer.toString(i), x - 3, centerY + 20);
            }
        }

        // Draw y-axis scale
        for (int i = -5; i <= 5; i++) {
            int y = centerY + i * gridSize;
            g.drawLine(centerX - 5, y, centerX + 5, y);
            if (i != 0) {
                g.drawString(Integer.toString(-i), centerX - 20, y + 3);
            }
        }

        // Plot the origin
        g.setColor(Color.BLUE);
        g.fillOval(centerX - 3, centerY - 3, 6, 6);

        // Plot the complex number
        int x = centerX + (int) (real * gridSize);
        int y = centerY - (int) (imaginary * gridSize);
        g.setColor(Color.RED);
        g.fillOval(x - 3, y - 3, 6, 6);

        if (showVector) {
            // Draw vector (if enabled)
            int vectorX = centerX + (int) (real * gridSize);
            int vectorY = centerY - (int) (imaginary * gridSize);
            g.setColor(Color.GREEN);
            g.drawLine(centerX, centerY, vectorX, vectorY);
        }
    }
}
