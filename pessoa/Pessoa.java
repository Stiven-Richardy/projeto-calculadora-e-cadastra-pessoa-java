/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 471 - LINGUAGEM DE PROGRAMAÇÃO II
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

package pessoa;

public class Pessoa {
    protected static int kp = 0;
    protected String nome;
    protected char sexo;
    protected int idade;

    public static int getKp() {
        return kp;
    }

    public static void setKp() {
        Pessoa.kp += 1;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa() {
        setKp();
        setNome("");
        setSexo('U');
        setIdade(0);
    }

    public Pessoa(String nome, char sexo, int idade) {
        setKp();
        setNome(nome);
        setSexo(sexo);
        setIdade(idade);
    }
}
