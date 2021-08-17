package dio.personapi.dto.request;

import dio.personapi.enums.EmailTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    private Long idEmail;

    @Enumerated
    private EmailTipo emailTipo;

    private String email;
}
