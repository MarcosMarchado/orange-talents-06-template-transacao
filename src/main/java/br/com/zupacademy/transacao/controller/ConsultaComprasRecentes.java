package br.com.zupacademy.transacao.controller;

import br.com.zupacademy.transacao.controller.dto.TransacoesResponse;
import br.com.zupacademy.transacao.exception.ObjectNotFoundException;
import br.com.zupacademy.transacao.modelo.Transacao;
import br.com.zupacademy.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class ConsultaComprasRecentes {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping
    public ResponseEntity<Page<TransacoesResponse>> consultaCompras(@RequestParam(value = "id", required = true) String idCartao,
                                                                    @PageableDefault(size = 10) Pageable pageable){

        Page<Transacao> transacoes = transacaoRepository.findByCartaoId(idCartao, pageable);
        if(transacoes.isEmpty()) throw new ObjectNotFoundException("Nenhuma transação encontrada com o número de Cartão informado");

        return ResponseEntity.ok(TransacoesResponse.converter(transacoes));
    }

}
