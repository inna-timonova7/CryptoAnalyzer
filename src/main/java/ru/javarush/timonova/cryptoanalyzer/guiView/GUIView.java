package ru.javarush.timonova.cryptoanalyzer.guiView;

import ru.javarush.timonova.cryptoanalyzer.controller.Operation;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUIView extends JFrame implements ActionListener {

    JButton buttonToUpload;
    static JFileChooser fileChooser;
    final JLabel label = new JLabel();
    private static final JButton EXECUTE = new JButton("Execute");
    public static final JButton EXIT = new JButton("EXIT");
    private static final JLabel BUTTON_MESSAGE = new JLabel("Please, upload a file");
    private static final JLabel ACTION_MESSAGE = new JLabel("Please, choose an action");
    private static final JLabel KEY_MESSAGE = new JLabel("Please, enter a KEY for Caesar Cypher");
    public static final JRadioButton ENCRYPT = new JRadioButton("Encrypt text");
    public static final JRadioButton DECRYPT = new JRadioButton("Decrypt text");
    public static final JRadioButton BRUTE_FORCE = new JRadioButton("BruteForce text");
    private static Object NumberFormatter;
    public static final JFormattedTextField KEY_INPUT = new JFormattedTextField(NumberFormatter);
    public static final JLabel RESULT = new JLabel("The result is saved on your PC Desktop");

    public GUIView() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Project Caesar Cypher");
        this.setBounds(300, 300, 600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3, 10, 10));

        buttonToUpload = new JButton("Upload a txt. File from Your PC");
        buttonToUpload.setFocusable(false);
        buttonToUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == buttonToUpload) {
                    fileChooser = new JFileChooser();
                    int response = fileChooser.showSaveDialog(null);

                    if (response == JFileChooser.APPROVE_OPTION) {
                        File filePath = new File(String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile()));
                    }
                }
            }
        });

        EXECUTE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == EXECUTE) {
                    int x = 0;
                    try {
                        x = Integer.parseInt(KEY_INPUT.getText());
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(panel, "Некорректный ввод! Можно ввести только число");
                    }
                    Operation operation = new Operation();
                    operation.performOperation();

                    JOptionPane.showMessageDialog(panel, "Success! Find the result on your Desktop");
                }
            }
        });

        EXIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(200);
            }
        });

        panel.add(BUTTON_MESSAGE);
        panel.add(buttonToUpload);
        panel.add(ACTION_MESSAGE);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ENCRYPT);
        buttonGroup.add(DECRYPT);
        buttonGroup.add(BRUTE_FORCE);

        panel.add(ENCRYPT);
        panel.add(DECRYPT);
        panel.add(BRUTE_FORCE);
        panel.add(KEY_MESSAGE);
        panel.add(KEY_INPUT);
        panel.add(EXECUTE, BorderLayout.WEST);
        panel.add(RESULT, BorderLayout.EAST);
        panel.add(EXIT, BorderLayout.EAST);

        this.add(panel).setForeground(Color.GRAY);
        this.setVisible(true);
    }

    public static String getFileSource() {
        return String.valueOf(new File(String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile())));
    }

    public static int getKey() {
        return Integer.parseInt(KEY_INPUT.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
