package com.lifebank.boleto.service;

import br.com.caelum.stella.boleto.*;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import com.lifebank.boleto.repository.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class BoletoServiceImpl implements BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    @Override
    public byte[] gerarBoleto(Long id) {

        com.lifebank.boleto.entity.Boleto b;
        Optional<com.lifebank.boleto.entity.Boleto> op = this.boletoRepository.findById(id);
        if (op.isPresent()) {
            b = op.get();
        } else {
            return null;
        }

        Datas datas = Datas.novasDatas().comDocumento(Calendar.getInstance())
                .comProcessamento(Calendar.getInstance()).comVencimento(Calendar.getInstance());

        Emissor emissor = Emissor.novoEmissor()
                .comCedente(b.getEmissor().getCedente())
                .comAgencia(b.getEmissor().getAgencia()).comDigitoAgencia(b.getEmissor().getAgenciaDigito())
                .comContaCorrente(b.getEmissor().getConta())
                .comNumeroConvenio(b.getEmissor().getConvenio())
                .comDigitoContaCorrente(b.getEmissor().getDigitoConta())
                .comCarteira(b.getEmissor().getCarteira())
                .comNossoNumero(b.getNossoNumero());

        Sacado sacado = Sacado.novoSacado()
                .comNome(b.getPessoa().getNome())
                .comCpf(b.getPessoa().getCpf())
                .comEndereco(b.getPessoa().getEndereco().getLogradouro())
                .comBairro(b.getPessoa().getEndereco().getBairro())
                .comCep(b.getPessoa().getEndereco().getCep())
                .comCidade(b.getPessoa().getEndereco().getCidade())
                .comUf(b.getPessoa().getEndereco().getUf());

        Banco banco = new BancoDoBrasil();

        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comDescricoes(b.getDescricao1(), b.getDescricao2(), b.getDescricao3(),
                        b.getDescricao4(), b.getDescricao5())
                .comEmissor(emissor)
                .comSacado(sacado)
                .comValorBoleto(b.getValor())
                .comInstrucoes(b.getInstrucao1(), b.getInstrucao2(),
                        b.getInstrucao3(), b.getInstrucao4(), b.getInstrucao5())
                .comLocaisDePagamento(b.getLocalPagamento1(), b.getLocalPagamento2())
                .comNumeroDoDocumento(b.getId().toString());

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String fileName = ts.toString();
        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);
        gerador.geraPDF("/tmp/" + fileName.replaceAll("[^\\d]", "") + ".pdf");

        @SuppressWarnings("unused")
        byte[] bPDF = gerador.geraPDF();

        return bPDF;
    }

    @Override
    public List<com.lifebank.boleto.entity.Boleto> listarBoletos() {
        return this.boletoRepository.findAll();
    }
}
