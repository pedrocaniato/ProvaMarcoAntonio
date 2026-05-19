package main.java.com.clinicaveterinaria.model;

public class Tutor {
    private String nome;
    private String email;

    public Tutor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}