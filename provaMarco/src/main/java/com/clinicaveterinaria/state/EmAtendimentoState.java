package main.java.com.clinicaveterinaria.state;

import main.java.com.clinicaveterinaria.model.Atendimento;


public class EmAtendimentoState implements SituacaoAtendimento {
    @Override
    public void agendar(Atendimento atendimento) {
        throw new IllegalStateException("Não é possível reagendar um atendimento em andamento.");
    }

    @Override
    public void iniciarAtendimento(Atendimento atendimento) {
        throw new IllegalStateException("O atendimento já está em andamento.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        atendimento.setSituacaoAtual(new FinalizadoState());
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Não é possível cancelar um atendimento em andamento.");
    }

    @Override
    public String getNomeSituacao() {
        return "Em Atendimento";
    }
}