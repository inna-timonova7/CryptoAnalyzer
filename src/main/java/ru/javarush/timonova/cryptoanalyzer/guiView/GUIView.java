package ru.javarush.timonova.cryptoanalyzer.guiView;

import ru.javarush.timonova.cryptoanalyzer.controller.Operation;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

        this.setLayout(new GridLayout(6, 3, 10, 10));

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
                    if (GUIView.ENCRYPT.isSelected() || GUIView.DECRYPT.isSelected()) {
                        KEY_INPUT.setAction(KEY_INPUT.getAction());
                    } if (GUIView.BRUTE_FORCE.isSelected()) {
                        GUIView.KEY_INPUT.disable();
                    }
                        Operation operation = new Operation();
                        operation.performOperation();
                        JOptionPane.showMessageDialog(null, "Success! Find the result on your Desktop", "Congrats!", JOptionPane.INFORMATION_MESSAGE);
                        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    }
                }
        });

        EXIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(200);
            }
        });

        KEY_INPUT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                }
                else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    KEY_INPUT.setText(" ");
                } else {
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
                    KEY_INPUT.setText(" ");
                }
            }
        });

        this.add(BUTTON_MESSAGE);
        this.add(buttonToUpload);
        this.add(ACTION_MESSAGE);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ENCRYPT);
        buttonGroup.add(DECRYPT);
        buttonGroup.add(BRUTE_FORCE);

        this.add(ENCRYPT);
        this.add(DECRYPT);
        this.add(BRUTE_FORCE);
        this.add(KEY_MESSAGE);
        this.add(KEY_INPUT);
        this.add(EXECUTE, BorderLayout.WEST);
        this.add(RESULT, BorderLayout.EAST);
        this.add(EXIT, BorderLayout.EAST);

        this.setForeground(Color.GRAY);
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
