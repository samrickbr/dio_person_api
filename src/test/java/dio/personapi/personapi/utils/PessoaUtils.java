package dio.personapi.personapi.utils;

import dio.personapi.personapi.dto.request.PessoaDTO;
import dio.personapi.personapi.entity.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String NOME_PESSOA = "Ricardo Cardoso";
    private static final String DOCUMENTO = "009.492.279-94";
    private static final long ID_PESSOA = 1L;
    private static final LocalDate DATA_NASCIMENTO = LocalDate.of(1984, 2, 28);

    public static PessoaDTO criarFakeDTO() {
        return PessoaDTO.builder()
                .nomePessoa(NOME_PESSOA)
                .documento(DOCUMENTO)
                .dataNascimento("28-12-1982")
                .endereco(Collections.singletonList(EnderecoUtils.criarFakeDTO()))
                .telefone(Collections.singletonList(TelefoneUtils.criarFakeDTO()))
                .email(Collections.singletonList(EmailUtils.criarFakeDTO()))
                .build();
    }

    public static Pessoa criarFakeEntity() {
        return Pessoa.builder()
                .idPessoa(ID_PESSOA)
                .nomePessoa(NOME_PESSOA)
                .documento(DOCUMENTO)
                .dataNascimento(DATA_NASCIMENTO)
                .endereco(Collections.singletonList(EnderecoUtils.criarFakeEntity()))
                .telefone(Collections.singletonList(TelefoneUtils.criarFakeEntity()))
                .email(Collections.singletonList(EmailUtils.criarFakeEntity()))
                .build();
    }

}
