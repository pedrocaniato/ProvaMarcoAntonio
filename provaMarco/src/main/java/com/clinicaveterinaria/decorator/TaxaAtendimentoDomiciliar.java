package main.java.com.clinicaveterinaria.decorator;

public class TaxaAtendimentoDomiciliar extends AtendimentoDecorator {
    private double taxaDomicilio;

    public TaxaAtendimentoDomiciliar(ServicoVeterinario servicoDecorado, double taxaDomicilio) {
        super(servicoDecorado);
        this.taxaDomicilio = taxaDomicilio;
    }

    @Override
    public double calcularValor() {
        return super.calcularValor() + taxaDomicilio;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Taxa de Atendimento Domiciliar";
    }
}