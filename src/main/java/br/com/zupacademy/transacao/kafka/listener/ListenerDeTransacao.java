package br.com.zupacademy.transacao.kafka.listener;

import br.com.zupacademy.transacao.kafka.mensagem.transacao.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(Transacao eventoDeTransacao) {
        logger.info("ID: {}", eventoDeTransacao.getId());
        logger.info("Valor: {}", eventoDeTransacao.getValor());
        logger.info("Nome do estabelecimento: {}", eventoDeTransacao.getEstabelecimento().getNome());
        logger.info("Cidade: {}", eventoDeTransacao.getEstabelecimento().getCidade());
        logger.info("Endereço: {}", eventoDeTransacao.getEstabelecimento().getEndereco());
        logger.info("Efetivado em: {}", eventoDeTransacao.getEfetivadaEm());
    }

}
