package com.epam.jolt.ui;

import com.epam.jolt.converter.Converter;

import javax.swing.*;
import java.awt.*;

public class Window {

    private static final String TEXT_APP = "JOLT converter";
    private static final String TEXT_BUTTON_CONVERT = "Convert";
    private static final String TEXT_WINDOW_INPUT = "Input";
    private static final String TEXT_WINDOW_JOLT_SPEC = "Jolt Spec";
    private static final String TEXT_WINDOW_OUTPUT = "Output";

    private static final int TEXT_WINDOW_COLS = 40;
    private static final int TEXT_WINDOW_ROWS = 60;

    private final JTextArea input;
    private final JTextArea jolt;
    private final JTextArea output;

    public Window(int width, int height) {
        JFrame frame = new JFrame(TEXT_APP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        //BUTTON
        JButton button = new JButton(TEXT_BUTTON_CONVERT);
        button.setBounds(130,100,100,40);
        button.addActionListener(new Converter(this));
        frame.add(button,BorderLayout.SOUTH);
        //TEXT AREA
        input = createTextArea(TEXT_WINDOW_INPUT);
        jolt = createTextArea(TEXT_WINDOW_JOLT_SPEC);
        output = createTextArea(TEXT_WINDOW_OUTPUT);
        frame.add(input, BorderLayout.WEST);
        frame.add(jolt, BorderLayout.CENTER);
        frame.add(output, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private JTextArea createTextArea(String placeholder) {
        JTextArea textArea = new JTextArea(placeholder, TEXT_WINDOW_ROWS, TEXT_WINDOW_COLS);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return textArea;
    }

    public JTextArea getInput() {
        return input;
    }

    public JTextArea getJolt() {
        return jolt;
    }

    public JTextArea getOutput() {
        return output;
    }
}
