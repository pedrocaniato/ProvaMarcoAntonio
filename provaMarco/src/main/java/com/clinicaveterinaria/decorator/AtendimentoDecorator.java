package main.java.com.clinicaveterinaria.decorator;

public abstract class AtendimentoDecorator implements ServicoVeterinario {
    protected ServicoVeterinario servicoDecorado;

    public AtendimentoDecorator(ServicoVeterinario servicoDecorado) {
        this.servicoDecorado = servicoDecorado;
    }

    @Override
    public double calcularValor() {
        return servicoDecorado.calcularValor();
    }

    @Override
    public String getDescricao() {
        return servicoDecorado.getDescricao();
    }
}