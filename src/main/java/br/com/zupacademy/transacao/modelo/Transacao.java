package br.com.zupacademy.transacao.modelo;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Transacao {

    @Id
    private String id;
    private BigDecimal valor;
    @Embedded
    private Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;
    private String efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

}

