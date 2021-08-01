package br.com.zupacademy.transacao.controller.dto;

import br.com.zupacademy.transacao.modelo.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class TransacoesResponse {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private String efetivadaEm;

    public TransacoesResponse(Transacao transacao){
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public static Page<TransacoesResponse> converter(Page<Transacao> transacoes){
        return transacoes.map(TransacoesResponse::new);
    }

}
