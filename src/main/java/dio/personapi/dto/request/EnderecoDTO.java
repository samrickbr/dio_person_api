package dio.personapi.dto.request;

import dio.personapi.enums.EnderecoTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long idEndereco;

    @Enumerated
    private EnderecoTipo enderecoTipo;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String complemento;

}
