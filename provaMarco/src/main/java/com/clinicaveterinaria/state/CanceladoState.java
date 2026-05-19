package main.java.com.clinicaveterinaria.state;

import main.java.com.clinicaveterinaria.model.Atendimento;

public class CanceladoState implements SituacaoAtendimento {
    @Override
    public void agendar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento cancelado não pode ser alterado.");
    }

    @Override
    public void iniciarAtendimento(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento cancelado não pode ser alterado.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento cancelado não pode ser alterado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("O atendimento já está cancelado.");
    }

    @Override
    public String getNomeSituacao() {
        return "Cancelado";
    }
}