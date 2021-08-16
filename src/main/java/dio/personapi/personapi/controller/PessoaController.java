package dio.personapi.personapi.controller;

import dio.personapi.personapi.dto.MensagemRespostaDTO;
import dio.personapi.personapi.entity.Pessoa;
import dio.personapi.personapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO criarPessoa(@RequestBody  Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }
}
