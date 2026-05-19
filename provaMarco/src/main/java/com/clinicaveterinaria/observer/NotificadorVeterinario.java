package main.java.com.clinicaveterinaria.observer;

import main.java.com.clinicaveterinaria.model.Atendimento;

public class NotificadorVeterinario implements InteressadoAtendimento {
    @Override
    public void atualizar(Atendimento atendimento) {
        if (atendimento.getSituacaoAtual().getNomeSituacao().equals("Cancelado")) {
            System.out.println("Aviso para o Veterinário: O atendimento do animal " + atendimento.getAnimal().getNome() + " foi cancelado.");
        }
    }
}