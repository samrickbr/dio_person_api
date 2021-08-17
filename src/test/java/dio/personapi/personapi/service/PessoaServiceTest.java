package dio.personapi.personapi.service;

import dio.personapi.personapi.dto.MensagemRespostaDTO;
import dio.personapi.personapi.dto.request.PessoaDTO;
import dio.personapi.personapi.entity.Pessoa;
import dio.personapi.personapi.mapper.PessoaMapper;
import dio.personapi.personapi.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static dio.personapi.personapi.utils.PessoaUtils.criarFakeDTO;
import static dio.personapi.personapi.utils.PessoaUtils.criarFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    /* Teste que verifica se a pessoa foi salva e retornou a mensagem de sucesso */
    @Test
    void TestCriarDTOComMensagemDeSucesso() {
        PessoaDTO pessoaDTO = criarFakeDTO();
        Pessoa expectPessoaSalva = criarFakeEntity();

        when(pessoaMapper.toModel(pessoaDTO)).thenReturn(expectPessoaSalva);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(expectPessoaSalva);

        MensagemRespostaDTO expectMensagem = expectedMensagemResposta(expectPessoaSalva.getIdPessoa());
        MensagemRespostaDTO mensagemSucesso = pessoaService.criarPessoa(pessoaDTO);

        assertEquals(expectMensagem, mensagemSucesso);

    }

    private MensagemRespostaDTO expectedMensagemResposta(Long id) {
        return MensagemRespostaDTO.builder()
                .mensagem("Pessoa salva com sucesso no ID " + id + "!")
                .build();
    }
}
