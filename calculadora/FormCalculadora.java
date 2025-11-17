/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 471 - LINGUAGEM DE PROGRAMAÇÃO II
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

package calculadora;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.lang.NumberFormatException;

public class FormCalculadora extends JFrame {
    private JTextField txtDisplay;
    private JPanel painelBotoes;
    private double num1 = 0;
    private String operador = "";
    private boolean novoNumero = false;

    public FormCalculadora() {
        setTitle("TP03 - LPR2 - Calc");
        setSize(250, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        txtDisplay = new JTextField("0");
        txtDisplay.setEditable(false);
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
        txtDisplay.setFont(new Font("SansSerif", Font.BOLD, 24));

        painelBotoes = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] labelsBotoes = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", "C" };
        for (String label : labelsBotoes) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("SansSerif", Font.BOLD, 16));
            btn.addActionListener(e -> {
                String comando = e.getActionCommand();
                processarClique(comando);
            });
            painelBotoes.add(btn);
        }

        add(txtDisplay, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
    }

    private void processarClique(String comando) {
        List<String> operadores = Arrays.asList("+", "-", "*", "/");

        if (comando.matches("[0-9]") || comando.equals(".")) {
            if (novoNumero) {
                txtDisplay.setText("");
                novoNumero = false;
            }

            if (comando.equals(".")) {
                if (!txtDisplay.getText().contains(".")) {
                    txtDisplay.setText(txtDisplay.getText() + ".");
                }
            } else {
                if (txtDisplay.getText().equals("0")) {
                    txtDisplay.setText(comando);
                } else {
                    txtDisplay.setText(txtDisplay.getText() + comando);
                }
            }
        } else if (comando.equals("C")) {
            txtDisplay.setText("0");
            num1 = 0;
            operador = "";
            novoNumero = false;
        } else if (operadores.contains(comando)) {
            boolean erro = false;
            if (!operador.isEmpty()) {
                processarClique("=");
            }
            try {
                num1 = Double.parseDouble(txtDisplay.getText());
            } catch (NumberFormatException error) {
                processarClique("C");
                erro = true;
                return;
            } finally {
                if (!erro) {
                    operador = comando;
                    novoNumero = true;
                }
            }
        } else if (comando.equals("=")) {
            double num2 = 0;
            try {
                num2 = Double.parseDouble(txtDisplay.getText());
            } catch (NumberFormatException error) {
                processarClique("C");
            }
            double total = 0;

            if (!operador.isEmpty()) {
                switch (operador) {
                    case "+":
                        total = num1 + num2;
                        break;
                    case "-":
                        total = num1 - num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            txtDisplay.setText("Inválido");
                        } else {
                            total = num1 / num2;
                        }
                        break;
                    case "*":
                        total = num1 * num2;
                        break;
                }

                txtDisplay.setText(String.format("%s", total).replace(",", "."));
            }

            num1 = total;
            operador = "";
            novoNumero = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormCalculadora().setVisible(true));
    }
}
