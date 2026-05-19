package main.java.com.clinicaveterinaria.decorator;

public class AtendimentoBase implements ServicoVeterinario {
    private String descricao;
    private double valorBase;

    public AtendimentoBase(String descricao, double valorBase) {
        this.descricao = descricao;
        this.valorBase = valorBase;
    }

    @Override
    public double calcularValor() {
        return valorBase;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}