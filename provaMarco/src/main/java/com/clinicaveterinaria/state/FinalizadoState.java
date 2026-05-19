package main.java.com.clinicaveterinaria.state;

import main.java.com.clinicaveterinaria.model.Atendimento;

public class FinalizadoState implements SituacaoAtendimento {
    @Override
    public void agendar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento finalizado não pode ser alterado.");
    }

    @Override
    public void iniciarAtendimento(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento finalizado não pode ser alterado.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("O atendimento já está finalizado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Um atendimento finalizado não pode ser cancelado.");
    }

    @Override
    public String getNomeSituacao() {
        return "Finalizado";
    }
}