package main.java.com.clinicaveterinaria.model;

import main.java.com.clinicaveterinaria.state.SituacaoAtendimento;
import main.java.com.clinicaveterinaria.state.AgendadoState;
import main.java.com.clinicaveterinaria.observer.InteressadoAtendimento;
import main.java.com.clinicaveterinaria.decorator.ServicoVeterinario;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {
    private Tutor tutor;
    private Animal animal;
    private ServicoVeterinario servico;
    private SituacaoAtendimento situacaoAtual;
    private List<InteressadoAtendimento> interessados = new ArrayList<>();

    public Atendimento(Tutor tutor, Animal animal, ServicoVeterinario servico) {
        this.tutor = tutor;
        this.animal = animal;
        this.servico = servico;
        this.situacaoAtual = new AgendadoState();
    }

    public void setSituacaoAtual(SituacaoAtendimento novaSituacao) {
        this.situacaoAtual = novaSituacao;
        notificarInteressados();
    }

    public void agendar() {
        situacaoAtual.agendar(this);
    }

    public void iniciarAtendimento() {
        situacaoAtual.iniciarAtendimento(this);
    }

    public void finalizar() {
        situacaoAtual.finalizar(this);
    }

    public void cancelar() {
        situacaoAtual.cancelar(this);
    }

    public void adicionarInteressado(InteressadoAtendimento interessado) {
        interessados.add(interessado);
    }

    public void removerInteressado(InteressadoAtendimento interessado) {
        interessados.remove(interessado);
    }

    private void notificarInteressados() {
        for (InteressadoAtendimento interessado : interessados) {
            interessado.atualizar(this);
        }
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Animal getAnimal() {
        return animal;
    }

    public ServicoVeterinario getServico() {
        return servico;
    }

    public SituacaoAtendimento getSituacaoAtual() {
        return situacaoAtual;
    }

    public double getValorFinal() {
        return servico.calcularValor();
    }
}