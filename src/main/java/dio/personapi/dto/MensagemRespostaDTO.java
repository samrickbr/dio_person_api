package dio.personapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensagemRespostaDTO {

    private String mensagem;
}
