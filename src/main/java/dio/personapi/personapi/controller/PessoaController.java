package dio.personapi.personapi.controller;

import dio.personapi.personapi.dto.MensagemRespostaDTO;
import dio.personapi.personapi.dto.request.PessoaDTO;
import dio.personapi.personapi.exception.PessoaNotFoundException;
import dio.personapi.personapi.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

    private PessoaService pessoaService;

    /* Cadastrar pessoa no DB */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.criarPessoa(pessoaDTO);
    }

    /* Listar todas as pessoas cadastradas */
    @GetMapping
    public List<PessoaDTO> listarTodos() {
        return pessoaService.listarTodos();
    }

    /* Buscar pessoa por ID */
    @GetMapping("/{id}")
    public PessoaDTO buscarID(@PathVariable Long id) throws PessoaNotFoundException {
        return PessoaService.buscarID(id);
    }

    /* Atualizar Pessoa por ID */
    @PutMapping("/{id}")
    public MensagemRespostaDTO atualizarPorID(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        return pessoaService.atualizarPorID(id, pessoaDTO);
    }

    /* Deletar pessoa por ID*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarID(@PathVariable Long id) throws PessoaNotFoundException {
        pessoaService.deleteID(id);
    }
}
