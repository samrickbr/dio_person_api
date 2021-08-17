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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private static PessoaRepository pessoaRepository;

    private static final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MensagemRespostaDTO criarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);

        Pessoa pessoaSalva = pessoaRepository.save(pessoaParaSalvar);
        return MensagemRespostaDTO.builder().mensagem("Pessoa salva com sucesso no ID "
                        + pessoaSalva.getIdPessoa() + "!")
                .build();
    }

    public List<PessoaDTO> listarTodos() {
        List<Pessoa> todasPessoas = pessoaRepository.findAll();
        return todasPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static PessoaDTO buscarID(Long id) throws PessoaNotFoundException {
       Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));

        return pessoaMapper.toDTO(pessoa);
    }
}
