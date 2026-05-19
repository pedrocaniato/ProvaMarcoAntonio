package main.java.com.clinicaveterinaria.decorator;

public class ServicoBanhoPosConsulta extends AtendimentoDecorator {
    private double valorBanho;

    public ServicoBanhoPosConsulta(ServicoVeterinario servicoDecorado, double valorBanho) {
        super(servicoDecorado);
        this.valorBanho = valorBanho;
    }

    @Override
    public double calcularValor() {
        return super.calcularValor() + valorBanho;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Banho Pós-Consulta";
    }
}