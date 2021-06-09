package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class GUI extends JFrame {
    private JButton buttonLoadFile;
    private JButton buttonSolve;
    private JTextArea textAreaResult;
    private JPanel panelGUI;
    private JTextArea textAreaInput;
    private JTextField textFieldRepeats;
    private JButton buttonMySolve;

    public GUI() {
        setVisible(true);
        setContentPane(panelGUI);
        setSize(800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        textAreaInput.setLineWrap(true);
        textAreaInput.setWrapStyleWord(true);
        textAreaResult.setLineWrap(true);
        textAreaResult.setWrapStyleWord(true);
        buttonLoadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("src/com/company/Tests"));
                fileChooser.showOpenDialog(panelGUI);
                Scanner scanner;
                try {
                    scanner = new Scanner(new File(fileChooser.getSelectedFile().getPath()));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showInputDialog("No file");
                    return;
                }
                readFromScanner(scanner);
            }
        });

        buttonSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaResult.setText("");
                List<String> words = Solution.solve(textAreaInput.getText(), Integer.parseInt(textFieldRepeats.getText()));
                for (String word: words) {
                    textAreaResult.append(word+"\n");
                }
            }
        });

        buttonMySolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaResult.setText("");
                List<String> words = Solution.mySolve(textAreaInput.getText(), Integer.parseInt(textFieldRepeats.getText()));
                for (String word: words) {
                    textAreaResult.append(word+"\n");
                }
            }
        });
    }

    private void readFromScanner(Scanner scanner) {
        textAreaInput.setText("");
        while (scanner.hasNextLine()) {
            textAreaInput.append(scanner.nextLine() + "\n");
        }
    }
}