
package main.java.com.clinicaveterinaria.observer;

import main.java.com.clinicaveterinaria.model.Atendimento;

public class NotificadorTutor implements InteressadoAtendimento {
    @Override
    public void atualizar(Atendimento atendimento) {
        if (atendimento.getSituacaoAtual().getNomeSituacao().equals("Em Atendimento")) {
            System.out.println("Aviso para o Tutor " + atendimento.getTutor().getNome() + ": O atendimento do animal " + atendimento.getAnimal().getNome() + " foi iniciado.");
        }
    }
}