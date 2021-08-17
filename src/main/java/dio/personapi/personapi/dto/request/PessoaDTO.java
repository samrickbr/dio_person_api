package dio.personapi.personapi.dto.request;

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

    @NotEmpty
    private String dataNascimento;

    @Valid
    private List<EnderecoDTO> endereco;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefone;

    @Valid
    private List<EmailDTO> email;
}
