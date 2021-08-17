package dio.personapi.personapi.dto.request;

import dio.personapi.personapi.entity.Email;
import dio.personapi.personapi.entity.Endereco;
import dio.personapi.personapi.entity.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long idPessoa;

    @NotEmpty
    @Size(min = 2, max = 200)
    private String nomePessoa;

    @NotEmpty
    @CPF
    private String documento;

    private String dataNascimento;

    private List<Endereco> endereços;

    @Valid
    @NotEmpty
    private List<Telefone> telefones;

    private List<Email> emails;
}
