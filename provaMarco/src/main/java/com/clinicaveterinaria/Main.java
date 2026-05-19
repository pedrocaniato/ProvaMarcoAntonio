package main.java.com.clinicaveterinaria;

import main.java.com.clinicaveterinaria.model.Animal;
import main.java.com.clinicaveterinaria.model.Atendimento;
import main.java.com.clinicaveterinaria.model.Tutor;
import main.java.com.clinicaveterinaria.observer.NotificadorRecepcao;
import main.java.com.clinicaveterinaria.observer.NotificadorTutor;
import main.java.com.clinicaveterinaria.observer.NotificadorVeterinario;
import main.java.com.clinicaveterinaria.decorator.AtendimentoBase;
import main.java.com.clinicaveterinaria.decorator.DescontoAnimalAdotado;
import main.java.com.clinicaveterinaria.decorator.ServicoBanhoPosConsulta;
import main.java.com.clinicaveterinaria.decorator.ServicoVeterinario;
import main.java.com.clinicaveterinaria.decorator.TaxaAtendimentoDomiciliar;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- CASO DE TESTE: FLUXO VALIDO E NOTIFICACOES ---");
        Tutor tutor1 = new Tutor("Pedro Lucas", "pedro@email.com");
        Animal animal1 = new Animal("Rex", "Cachorro");
        ServicoVeterinario consultaBase = new AtendimentoBase("Consulta de Rotina", 150.0);

        Atendimento atendimento1 = new Atendimento(tutor1, animal1, consultaBase);
        atendimento1.adicionarInteressado(new NotificadorTutor());
        atendimento1.adicionarInteressado(new NotificadorVeterinario());
        atendimento1.adicionarInteressado(new NotificadorRecepcao());

        System.out.println("Situacao Inicial: " + atendimento1.getSituacaoAtual().getNomeSituacao());
        
        atendimento1.iniciarAtendimento();
        System.out.println("Situacao Atual: " + atendimento1.getSituacaoAtual().getNomeSituacao());
        
        atendimento1.finalizar();
        System.out.println("Situacao Atual: " + atendimento1.getSituacaoAtual().getNomeSituacao());

        System.out.println("\n--- CASO DE TESTE: TRANSICAO INVALIDA ---");
        Atendimento atendimento2 = new Atendimento(tutor1, animal1, consultaBase);
        try {
            atendimento2.finalizar();
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado capturado: " + e.getMessage());
        }

        System.out.println("\n--- CASO DE TESTE: ENVIO DE AVISO NO CANCELAMENTO ---");
        Atendimento atendimento3 = new Atendimento(tutor1, animal1, consultaBase);
        atendimento3.adicionarInteressado(new NotificadorVeterinario());
        atendimento3.cancelar();

        System.out.println("\n--- CASO DE TESTE: MULTIPLAS REGRAS DE VALOR (DECORATOR) ---");
        Animal animalAdotado = new Animal("Luna", "Gato");
        ServicoVeterinario servicoComposto = new AtendimentoBase("Consulta Geral", 100.0);
        
        servicoComposto = new DescontoAnimalAdotado(servicoComposto);
        servicoComposto = new TaxaAtendimentoDomiciliar(servicoComposto, 50.0);
        servicoComposto = new ServicoBanhoPosConsulta(servicoComposto, 40.0);

        Atendimento atendimentoDecorado = new Atendimento(tutor1, animalAdotado, servicoComposto);
        
        System.out.println("Descricao dos servicos: " + atendimentoDecorado.getServico().getDescricao());
        System.out.println("Valor Final Calculado: R$ " + atendimentoDecorado.getValorFinal());
    }
}