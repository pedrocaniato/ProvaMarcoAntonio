package main.java.com.clinicaveterinaria.decorator;

public class DescontoAnimalAdotado extends AtendimentoDecorator {
    public DescontoAnimalAdotado(ServicoVeterinario servicoDecorado) {
        super(servicoDecorado);
    }

    @Override
    public double calcularValor() {
        return super.calcularValor() * 0.90;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Desconto Animal Adotado (10%)";
    }
}