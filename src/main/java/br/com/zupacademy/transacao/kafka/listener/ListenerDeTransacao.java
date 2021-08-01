package br.com.zupacademy.transacao.kafka.listener;

import br.com.zupacademy.transacao.modelo.Transacao;
import br.com.zupacademy.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(Transacao eventoDeTransacao) {
        transacaoRepository.save(eventoDeTransacao);
    }

}
