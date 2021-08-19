package dio.personapi.service;

import dio.personapi.dto.MensagemRespostaDTO;
import dio.personapi.dto.request.PessoaDTO;
import dio.personapi.entity.Pessoa;
import dio.personapi.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static dio.personapi.utils.PessoaUtils.criarFakeDTO;
import static dio.personapi.utils.PessoaUtils.criarFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testeGivenPersonDTOThenReturnSavedMessage() {
        PessoaDTO pessoaDTO = criarFakeDTO(); /* caso ocorra erro, aqui foi feito um import statico da classe PessoaUtils*/
        Pessoa expectedSavedPerson = criarFakeEntity();

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(expectedSavedPerson);

        MensagemRespostaDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getIdPessoa());

        MensagemRespostaDTO successMessage = pessoaService.criarPessoa(pessoaDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MensagemRespostaDTO createExpectedSuccessMessage(Long id) {
        return MensagemRespostaDTO.builder()
                .mensagem("Pessoa salva com sucesso no ID " + id + "!")
                .build();
    }
}


