package com.lifebank.boleto.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "pessoas")
public class Pessoa extends GenericEntity {

    private String nome;
    private String cpf;

    @OneToOne(mappedBy = "pessoa")
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
