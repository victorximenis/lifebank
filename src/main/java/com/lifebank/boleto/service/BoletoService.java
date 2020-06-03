package com.lifebank.boleto.service;

import com.lifebank.boleto.entity.Boleto;

import java.util.List;

public interface BoletoService {

    byte[] gerarBoleto(Long id);

    List<Boleto> listarBoletos();

}
