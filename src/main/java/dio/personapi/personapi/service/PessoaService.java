package dio.personapi.personapi.service;

import dio.personapi.personapi.dto.MensagemRespostaDTO;
import dio.personapi.personapi.entity.Pessoa;
import dio.personapi.personapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MensagemRespostaDTO criarPessoa(Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return MensagemRespostaDTO.builder().mensagem("Pessoa salva com sucesso no ID "
                + pessoaSalva.getIdPessoa() + "!").build();
    }
}
