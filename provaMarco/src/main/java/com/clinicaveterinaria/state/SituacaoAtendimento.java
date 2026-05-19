package main.java.com.clinicaveterinaria.state;

import main.java.com.clinicaveterinaria.model.Atendimento;

public interface SituacaoAtendimento {
    void agendar(Atendimento atendimento);
    void iniciarAtendimento(Atendimento atendimento);
    void finalizar(Atendimento atendimento);
    void cancelar(Atendimento atendimento);
    String getNomeSituacao();
}