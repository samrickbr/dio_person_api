package dio.personapi.personapi.service;

import dio.personapi.personapi.dto.MensagemRespostaDTO;
import dio.personapi.personapi.dto.request.PessoaDTO;
import dio.personapi.personapi.entity.Pessoa;
import dio.personapi.personapi.exception.PessoaNotFoundException;
import dio.personapi.personapi.mapper.PessoaMapper;
import dio.personapi.personapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private static PessoaRepository pessoaRepository;

    private static final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /* Salvar a pessoa no DB  */
    public MensagemRespostaDTO criarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);

        Pessoa pessoaSalva = pessoaRepository.save(pessoaParaSalvar);
        return MensagemRespostaDTO.builder().mensagem("Pessoa salva com sucesso no ID "
                        + pessoaSalva.getIdPessoa() + "!")
                .build();
    }

    /* Método para listar todas as pessoas no DB */
    public List<PessoaDTO> listarTodos() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return todasPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    /* Método para buscar pessoa por ID */
    public static PessoaDTO buscarID(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = verificaPessoaExiste(id);
        return pessoaMapper.toDTO(pessoa);
    }

    /* Método para deletar pessoa por ID */
    public void deleteID(Long id) throws PessoaNotFoundException {
        verificaPessoaExiste(id);
        pessoaRepository.deleteById(id);
    }

    /* Método para procurar pessoa por ID */
    private static Pessoa verificaPessoaExiste(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));
    }
}
