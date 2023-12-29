import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton addButton, subButton, mulButton, divButton, equalButton, clearButton;
    private JPanel panel;

    private double firstNumber, secondNumber, result;
    private String operator;

    public CalculatorApp() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);

        numberButtons = new JButton[10];
        operatorButtons = new JButton[5];

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);

        panel.add(numberButtons[0]);
        panel.add(clearButton);
        panel.add(equalButton);
        panel.add(divButton);

        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(this);
        }

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();

        if (buttonText.matches("[0-9]")) {
            textField.setText(textField.getText() + buttonText);
        } else if (buttonText.equals("+")) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        } else if (buttonText.equals("-")) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        } else if (buttonText.equals("*")) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        } else if (buttonText.equals("/")) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        } else if (buttonText.equals("=")) {
            secondNumber = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }

            textField.setText(String.valueOf(result));
        } else if (buttonText.equals("C")) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorApp();
            }
        });
    }
}
