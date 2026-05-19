package main.java.com.clinicaveterinaria.observer;

import main.java.com.clinicaveterinaria.model.Atendimento;

public interface InteressadoAtendimento {
    void atualizar(Atendimento atendimento);
}