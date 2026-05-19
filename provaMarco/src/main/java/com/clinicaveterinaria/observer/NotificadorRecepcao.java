package main.java.com.clinicaveterinaria.observer;

import main.java.com.clinicaveterinaria.model.Atendimento;

public class NotificadorRecepcao implements InteressadoAtendimento {
    @Override
    public void atualizar(Atendimento atendimento) {
        if (atendimento.getSituacaoAtual().getNomeSituacao().equals("Finalizado")) {
            System.out.println("Aviso para a Recepção: O atendimento do tutor " + atendimento.getTutor().getNome() + " foi finalizado. Valor total a cobrar: R$ " + atendimento.getValorFinal());
        }
    }
}