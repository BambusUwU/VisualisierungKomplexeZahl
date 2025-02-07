package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ComplexNumberCalculator extends JPanel {
    private JTextField calcRealField1;
    private JTextField plotRealField1;
    private JTextField imaginaryField1;
    private JTextField calcImaginaryField1;
    private JTextField realField2;
    private JTextField imaginaryField2;
    private ComplexNumberPlot plotPanel;

    public ComplexNumberCalculator() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        ComplexNumberPlot myComplexNumberPlot = new ComplexNumberPlot();

        // Plot Button
        JButton plotButton = new JButton("Plot");
        topPanel.add(plotButton);

        // Toggle Vector RadioButton
        JRadioButton toggleVectorButton = new JRadioButton("Toggle Vector");
        topPanel.add(toggleVectorButton);

        // Rechner Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        JPanel calcPanel = new JPanel();
        JLabel calcRealLabel = new JLabel("Real:");
        plotRealField1 = new JTextField(5);
        JLabel calcImaginaryLabel = new JLabel("Imaginary:");
        imaginaryField1 = new JTextField(5);

        calcPanel.add(calcRealLabel);
        calcPanel.add(plotRealField1);
        calcPanel.add(calcImaginaryLabel);
        calcPanel.add(imaginaryField1);
        calcPanel.add(topPanel); // Add the topPanel to include Plot and Toggle Vector buttons

        plotPanel = new ComplexNumberPlot();

        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double real = Double.parseDouble(plotRealField1.getText());
                double imaginary = Double.parseDouble(imaginaryField1.getText());
                plotPanel.plotComplexNumber(real, imaginary);
            }
        });
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel vectorLength = new JLabel("Vector Length: "); // Hier korrigiert
        JLabel vecLength = new JLabel("");


        toggleVectorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plotPanel.toggleVector();
                if (!Objects.equals(plotRealField1.getText(), "") || !Objects.equals(imaginaryField1.getText(), "")) {
                    vecLength.setText(
                            String.valueOf(
                                    calculateVectorLength(
                                            Double.parseDouble(plotRealField1.getText()),
                                                Double.parseDouble(imaginaryField1.getText( ))
                                    )
                            )
                    );
                }
            }
        });

        leftPanel.add(calcPanel, BorderLayout.NORTH);
        leftPanel.add(plotPanel, BorderLayout.CENTER);

        // Neues Panel für weitere Funktionen
        JButton addButton = new JButton("Add");
        JButton subButton = new JButton("Sub");
        JButton multButton = new JButton("Mult");
        JButton divButton = new JButton("Div");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);

        JLabel inputLabel1 = new JLabel("Input 1:");
        calcRealField1 = new JTextField(5);
        calcRealField1.setToolTipText("double");
        calcImaginaryField1 = new JTextField(5);
        calcRealField1.setToolTipText("double");

        JLabel inputLabel2 = new JLabel("Input 2:");
        realField2 = new JTextField(5);
        imaginaryField2 = new JTextField(5);

        rightPanel.add(inputLabel1, gbc);
        gbc.gridx++;
        rightPanel.add(calcRealField1, gbc);
        gbc.gridx++;
        rightPanel.add(new JLabel("+"), gbc);
        gbc.gridx++;
        rightPanel.add(calcImaginaryField1, gbc);
        gbc.gridx++;
        rightPanel.add(new JLabel("i"), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(inputLabel2, gbc);
        gbc.gridx++;
        rightPanel.add(realField2, gbc);
        gbc.gridx++;
        rightPanel.add(new JLabel("+"), gbc);
        gbc.gridx++;
        rightPanel.add(imaginaryField2, gbc);
        gbc.gridx++;
        rightPanel.add(new JLabel("i"), gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        rightPanel.add(addButton, gbc);
        gbc.gridx++;
        rightPanel.add(subButton, gbc);
        gbc.gridx++;
        rightPanel.add(multButton, gbc);
        gbc.gridx++;
        rightPanel.add(divButton, gbc);
        gbc.gridwidth = 4; // Spannweite über vier Spalten
        gbc.gridx = 0;
        gbc.gridy = 3;

        JLabel resultLabel = new JLabel("Ergebnis:");
        rightPanel.add(resultLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;

        rightPanel.add(vectorLength, gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double real1 = Double.parseDouble(calcRealField1.getText());
                double imaginary1 = Double.parseDouble(calcImaginaryField1.getText());
                double real2 = Double.parseDouble(realField2.getText());
                double imaginary2 = Double.parseDouble(imaginaryField2.getText());

                double sumReal = real1 + real2;
                double sumImaginary = imaginary1 + imaginary2;

                resultLabel.setForeground(Color.BLACK);
                resultLabel.setText("Ergebnis: " + sumReal + " + " + sumImaginary + "i");
            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double real1 = Double.parseDouble(calcRealField1.getText());
                double imaginary1 = Double.parseDouble(calcImaginaryField1.getText());
                double real2 = Double.parseDouble(realField2.getText());
                double imaginary2 = Double.parseDouble(imaginaryField2.getText());

                double diffReal = real1 - real2;
                double diffImaginary = imaginary1 - imaginary2;

                resultLabel.setForeground(Color.BLACK);
                resultLabel.setText("Ergebnis: " + diffReal + " + " + diffImaginary + "i");
            }
        });

        multButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double real1 = Double.parseDouble(calcRealField1.getText());
                double imaginary1 = Double.parseDouble(calcImaginaryField1.getText());
                double real2 = Double.parseDouble(realField2.getText());
                double imaginary2 = Double.parseDouble(imaginaryField2.getText());

                double productReal = (real1 * real2) - (imaginary1 * imaginary2);
                double productImaginary = (real1 * imaginary2) + (imaginary1 * real2);

                resultLabel.setForeground(Color.BLACK);
                resultLabel.setText("Ergebnis: " + productReal + " + " + productImaginary + "i");
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double real1 = Double.parseDouble(calcRealField1.getText());
                double imaginary1 = Double.parseDouble(calcImaginaryField1.getText());
                double real2 = Double.parseDouble(realField2.getText());
                double imaginary2 = Double.parseDouble(imaginaryField2.getText());

                if (real2 == 0 && imaginary2 == 0) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Division durch Null ist nicht möglich.");

                } else {
                    // Division durchführen
                    double divisor = real2 * real2 + imaginary2 * imaginary2;
                    double quotientReal = (real1 * real2 + imaginary1 * imaginary2) / divisor;
                    double quotientImaginary = (imaginary1 * real2 - real1 * imaginary2) / divisor;

                    resultLabel.setForeground(Color.BLACK);
                    resultLabel.setText("Ergebnis: " + quotientReal + " + " + quotientImaginary + "i");
                }
            }
        });

        add(leftPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    }

    public double calculateVectorLength(double real, double imaginary) {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

}
