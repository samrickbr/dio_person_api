package dio.personapi.dto.request;

import dio.personapi.enums.TelefoneTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long idTelefone;

    @Enumerated(EnumType.STRING)
    private TelefoneTipo telefoneTipo;

    @NotEmpty
    @Size(min = 12, max = 14)
    private String numero;

}
