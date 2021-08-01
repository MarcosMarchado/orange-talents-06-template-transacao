package br.com.zupacademy.transacao.exception;

import java.util.List;

public class ErroPadrao {
    private List<String> mensagens;

    public ErroPadrao(List<String> mensagens) {
        this.mensagens = mensagens;
    }

    public List<String> getMensagens() {
        return mensagens;
    }
}
