package br.com.zupacademy.transacao.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {
    @Id
    private String id;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
