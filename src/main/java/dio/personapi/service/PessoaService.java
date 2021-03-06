package dio.personapi.service;

import dio.personapi.dto.MensagemRespostaDTO;
import dio.personapi.dto.request.PessoaDTO;
import dio.personapi.entity.Pessoa;
import dio.personapi.exception.PessoaNotFoundException;
import dio.personapi.mapper.PessoaMapper;
import dio.personapi.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    /* Salvar a pessoa no DB  */
    public MensagemRespostaDTO criarPessoa(PessoaDTO pessoaDTO) {

        Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaSalva = pessoaRepository.save(pessoaParaSalvar);

        MensagemRespostaDTO messageresponse = createdMessageresponse(pessoaSalva.getIdPessoa(),"Pessoa salva com sucesso no ID ","!");

        return messageresponse;
    }

    /* Método para buscar pessoa por ID */
    public PessoaDTO buscarID(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));  //verificaPessoaExiste(id);
        return pessoaMapper.toDTO(pessoa);
    }

    /* Método para listar todas as pessoas no DB */
    public List<PessoaDTO> listarTodos() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return todasPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    /* Método para deletar pessoa por ID */
    public void deleteID(Long id) throws PessoaNotFoundException {
        verificaPessoaExiste(id);
        pessoaRepository.deleteById(id);
    }

    /* Método para atualizar a pessoa por ID */
    public MensagemRespostaDTO atualizarPorID(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        verificaPessoaExiste(id);
        Pessoa pessoaParaAtualizar = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaAtualizada = pessoaRepository.save(pessoaParaAtualizar);
        return createdMessageresponse(pessoaAtualizada.getIdPessoa(), "Pessoa com ID ", " atualizada com sucesso!");
    }

    /* Método para procurar pessoa por ID */
    private Pessoa verificaPessoaExiste(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));
    }

    /* Contrutor da mensagem para salvar e atualizar pessoa */
    private MensagemRespostaDTO createdMessageresponse(Long id, String mensagem1, String mensagem2) {
        return MensagemRespostaDTO.builder().mensagem(mensagem1 +
                        id + mensagem2)
                .build();
    }
}