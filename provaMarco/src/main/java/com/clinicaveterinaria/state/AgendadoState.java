package main.java.com.clinicaveterinaria.state;

import main.java.com.clinicaveterinaria.model.Atendimento;


public class AgendadoState implements SituacaoAtendimento {
    @Override
    public void agendar(Atendimento atendimento) {
        throw new IllegalStateException("O atendimento já está agendado.");
    }

    @Override
    public void iniciarAtendimento(Atendimento atendimento) {
        atendimento.setSituacaoAtual(new EmAtendimentoState());
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Não é possível finalizar um atendimento que ainda não foi iniciado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        atendimento.setSituacaoAtual(new CanceladoState());
    }

    @Override
    public String getNomeSituacao() {
        return "Agendado";
    }
}