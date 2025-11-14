/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 471 - LINGUAGEM DE PROGRAMAÇÃO II
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

package pessoa;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class FormPessoaV1 extends JFrame {
    private List<Pessoa> listaPessoas = new ArrayList<>();

    private JPanel painelSuperior;
    private JPanel painelInferior;

    private JTextField txtNumero = new JTextField(20);
    private JTextField txtNome = new JTextField(20);
    private JTextField txtSexo = new JTextField(20);
    private JTextField txtIdade = new JTextField(20);

    private JButton btnSalvar = new JButton("Salvar");
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnMostrar = new JButton("Mostrar");
    private JButton btnSair = new JButton("Sair");

    public FormPessoaV1() {
        setTitle("TP03 - LPR2 - V1");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        painelSuperior = new JPanel(new GridLayout(4, 2, 10, 10));
        painelInferior = new JPanel(new GridLayout(1, 4, 10, 10));

        txtNumero.setEditable(false);
        txtNumero.setText(Integer.toString(Pessoa.getKp()));
        painelSuperior.add(new JLabel("Numero:"));
        painelSuperior.add(txtNumero);

        painelSuperior.add(new JLabel("Nome:"));
        painelSuperior.add(txtNome);

        painelSuperior.add(new JLabel("Sexo:"));
        painelSuperior.add(txtSexo);

        painelSuperior.add(new JLabel("Idade:"));
        painelSuperior.add(txtIdade);

        painelInferior.add(btnSalvar);
        painelInferior.add(btnLimpar);
        painelInferior.add(btnMostrar);
        painelInferior.add(btnSair);

        btnSalvar.addActionListener(e -> cadastraPessoa());
        btnLimpar.addActionListener(e -> limpaTexto());
        btnMostrar.addActionListener(e -> mostraPessoas());
        btnSair.addActionListener(e -> System.exit(0));

        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);
    }

    private void cadastraPessoa() {
        String nome = txtNome.getText().trim();
        String sexo = txtSexo.getText().trim().toUpperCase();
        String idadeStr = txtIdade.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "O campo Nome é obrigatório.",
                    "Erro de Validação",
                    JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocus();
            return;
        }

        if (sexo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "O campo Sexo é obrigatório.",
                    "Erro de Validação",
                    JOptionPane.WARNING_MESSAGE);
            txtSexo.requestFocus();
            return;
        }

        if (!sexo.equals("M") && !sexo.equals("F")) {
            JOptionPane.showMessageDialog(this,
                    "O campo Sexo deve ser 'M' ou 'F'.",
                    "Erro de Validação",
                    JOptionPane.WARNING_MESSAGE);
            txtSexo.requestFocus();
            return;
        }

        if (idadeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "O campo Idade é obrigatório.",
                    "Erro de Validação",
                    JOptionPane.WARNING_MESSAGE);
            txtIdade.requestFocus();
            return;
        }

        int idadeNum;
        try {
            idadeNum = Integer.parseInt(idadeStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "O campo Idade deve ser um número inteiro válido.",
                    "Erro de Formato",
                    JOptionPane.ERROR_MESSAGE);
            txtIdade.requestFocus();
            return;
        }

        if (idadeNum < 0) {
            JOptionPane.showMessageDialog(this,
                    "O campo Idade não pode ser negativo.",
                    "Erro de Validação",
                    JOptionPane.WARNING_MESSAGE);
            txtIdade.requestFocus();
            return;
        }

        try {
            Pessoa umaPessoa = new Pessoa(nome, sexo.charAt(0), idadeNum);
            listaPessoas.add(umaPessoa);

            JOptionPane.showMessageDialog(this,
                    "Pessoa cadastrada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            limpaTexto();
            txtNumero.setText(Integer.toString(Pessoa.getKp()));

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erro no Cadastro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpaTexto() {
        txtNome.setText("");
        txtSexo.setText("");
        txtIdade.setText("");
        txtNome.requestFocus();
    }

    private void mostraPessoas() {
        if (listaPessoas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhuma pessoa cadastrada.",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder mensagem = new StringBuilder("Pessoas Cadastradas:\n\n");
        for (Pessoa pessoa : listaPessoas) {
            mensagem.append("Nome: ").append(pessoa.getNome());
            mensagem.append(" | Sexo: ").append(pessoa.getSexo());
            mensagem.append(" | Idade: ").append(pessoa.getIdade()).append(" anos\n");
        }
        mensagem.append("\nTotal de Pessoas: " + Pessoa.getKp());

        JOptionPane.showMessageDialog(this,
                mensagem.toString(),
                "Pessoas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPessoaV1().setVisible(true));
    }
}