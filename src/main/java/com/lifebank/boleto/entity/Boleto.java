package com.lifebank.boleto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "boletos")
public class Boleto extends GenericEntity {

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "emissor_id")
    private Emissor emissor;

    private Double valor;

    @Column(name = "nosso_numero")
    private Integer nossoNumero;

    @Column(name = "descricao_1")
    private String descricao1;

    @Column(name = "descricao_2")
    private String descricao2;

    @Column(name = "descricao_3")
    private String descricao3;

    @Column(name = "descricao_4")
    private String descricao4;

    @Column(name = "descricao_5")
    private String descricao5;

    @Column(name = "instrucao_1")
    private String instrucao1;

    @Column(name = "instrucao_2")
    private String instrucao2;

    @Column(name = "instrucao_3")
    private String instrucao3;

    @Column(name = "instrucao_4")
    private String instrucao4;

    @Column(name = "instrucao_5")
    private String instrucao5;

    @Column(name = "local_pagamento1")
    private String localPagamento1;

    @Column(name = "local_pagamento2")
    private String localPagamento2;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Emissor getEmissor() {
        return emissor;
    }

    public void setEmissor(Emissor emissor) {
        this.emissor = emissor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(Integer nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getDescricao1() {
        return descricao1;
    }

    public void setDescricao1(String descricao1) {
        this.descricao1 = descricao1;
    }

    public String getDescricao2() {
        return descricao2;
    }

    public void setDescricao2(String descricao2) {
        this.descricao2 = descricao2;
    }

    public String getDescricao3() {
        return descricao3;
    }

    public void setDescricao3(String descricao3) {
        this.descricao3 = descricao3;
    }

    public String getDescricao4() {
        return descricao4;
    }

    public void setDescricao4(String descricao4) {
        this.descricao4 = descricao4;
    }

    public String getDescricao5() {
        return descricao5;
    }

    public void setDescricao5(String descricao5) {
        this.descricao5 = descricao5;
    }

    public String getInstrucao1() {
        return instrucao1;
    }

    public void setInstrucao1(String instrucao1) {
        this.instrucao1 = instrucao1;
    }

    public String getInstrucao2() {
        return instrucao2;
    }

    public void setInstrucao2(String instrucao2) {
        this.instrucao2 = instrucao2;
    }

    public String getInstrucao3() {
        return instrucao3;
    }

    public void setInstrucao3(String instrucao3) {
        this.instrucao3 = instrucao3;
    }

    public String getInstrucao4() {
        return instrucao4;
    }

    public void setInstrucao4(String instrucao4) {
        this.instrucao4 = instrucao4;
    }

    public String getInstrucao5() {
        return instrucao5;
    }

    public void setInstrucao5(String instrucao5) {
        this.instrucao5 = instrucao5;
    }

    public String getLocalPagamento1() {
        return localPagamento1;
    }

    public void setLocalPagamento1(String localPagamento1) {
        this.localPagamento1 = localPagamento1;
    }

    public String getLocalPagamento2() {
        return localPagamento2;
    }

    public void setLocalPagamento2(String localPagamento2) {
        this.localPagamento2 = localPagamento2;
    }
}
