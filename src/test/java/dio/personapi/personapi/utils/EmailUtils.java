package dio.personapi.personapi.utils;

import dio.personapi.personapi.dto.request.EmailDTO;
import dio.personapi.personapi.entity.Email;
import dio.personapi.personapi.enums.EmailTipo;

public class EmailUtils {

    private static final String EMAIL = "ricardocardoso@gmail.com";
    private static final EmailTipo EMAIL_TIPO = EmailTipo.PESSOAL;
    private static final long ID_EMAIL = 1L;

    public static EmailDTO criarFakeDTO() {
        return EmailDTO.builder()
                .email(EMAIL)
                .emailTipo(EMAIL_TIPO)
                .build();
    }

    public static Email criarFakeEntity() {
        return Email.builder()
                .idEmail(ID_EMAIL)
                .email(EMAIL)
                .emailTipo(EMAIL_TIPO)
                .build();
    }
}
