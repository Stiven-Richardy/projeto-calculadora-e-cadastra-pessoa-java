/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 471 - LINGUAGEM DE PROGRAMAÇÃO II
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

package pessoa;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FormPessoaV2 extends JFrame {
    private List<Pessoa> listaPessoas = new ArrayList<>();

    private JPanel painelSuperior;
    private JPanel painelInferior;

    private JTextField txtNumero = new JTextField(20);
    private JTextField txtNome = new JTextField(20);
    private JTextField txtIdade = new JTextField(20);

    private String[] opcoes = { "M", "F" };
    private JComboBox<String> cbSexo = new JComboBox<>(opcoes);

    private JButton btnSalvar = new JButton("Salvar");
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnMostrar = new JButton("Mostrar");
    private JButton btnSair = new JButton("Sair");

    public FormPessoaV2() {
        this.setTitle("TP03 - LPR2 - V2");
        this.setSize(400, 180);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(5, 5));

        this.painelSuperior = new JPanel(new GridLayout(4, 2, 10, 10));
        this.painelInferior = new JPanel(new GridLayout(1, 4, 10, 10));

        this.txtNumero.setEditable(false);
        this.txtNumero.setText(Integer.toString(Pessoa.getKp()));

        this.painelSuperior.add(new JLabel("Numero:"));
        this.painelSuperior.add(this.txtNumero);

        this.painelSuperior.add(new JLabel("Nome:"));
        this.painelSuperior.add(this.txtNome);

        this.painelSuperior.add(new JLabel("Sexo:"));
        this.painelSuperior.add(this.cbSexo);

        this.painelSuperior.add(new JLabel("Idade:"));
        this.painelSuperior.add(this.txtIdade);

        this.painelInferior.add(this.btnSalvar);
        this.painelInferior.add(this.btnLimpar);
        this.painelInferior.add(this.btnMostrar);
        this.painelInferior.add(this.btnSair);

        this.btnSalvar.addActionListener(e -> cadastraPessoa());
        this.btnLimpar.addActionListener(e -> limpaTexto());
        this.btnMostrar.addActionListener(e -> mostraPessoas());
        this.btnSair.addActionListener(e -> System.exit(0));

        this.add(this.painelSuperior, BorderLayout.CENTER);
        this.add(this.painelInferior, BorderLayout.SOUTH);
    }

    private void cadastraPessoa() {
        String nome = this.txtNome.getText().trim();
        String idadeStr = this.txtIdade.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "O campo Nome é obrigatório.",
                    "Erro de Validação",
                    JOptionPane.WARNING_MESSAGE);
            this.txtNome.requestFocus();
            return;
        }

        if (idadeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "O campo Idade é obrigatório.",
                    "Erro de Validação",
                    JOptionPane.WARNING_MESSAGE);
            this.txtIdade.requestFocus();
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
            this.txtIdade.requestFocus();
            return;
        }

        if (idadeNum < 0) {
            JOptionPane.showMessageDialog(this,
                    "O campo Idade não pode ser negativo.",
                    "Erro de Validação",
                    JOptionPane.WARNING_MESSAGE);
            this.txtIdade.requestFocus();
            return;
        }

        try {
            String sexoStr = (String) this.cbSexo.getSelectedItem();
            char sexo = sexoStr.charAt(0);

            Pessoa umaPessoa = new Pessoa(nome, sexo, idadeNum);
            this.listaPessoas.add(umaPessoa);

            JOptionPane.showMessageDialog(this,
                    "Pessoa cadastrada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            limpaTexto();
            this.txtNumero.setText(Integer.toString(Pessoa.getKp()));

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erro no Cadastro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpaTexto() {
        this.txtNome.setText("");
        this.txtIdade.setText("");
        this.cbSexo.setSelectedIndex(0);
        this.txtNome.requestFocus();
    }

    private void mostraPessoas() {
        if (this.listaPessoas.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nenhuma pessoa cadastrada.",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder mensagem = new StringBuilder("Pessoas Cadastradas:\n\n");
        for (Pessoa pessoa : this.listaPessoas) {
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
        SwingUtilities.invokeLater(() -> {
            (new FormPessoaV2()).setVisible(true);
        });
    }
}