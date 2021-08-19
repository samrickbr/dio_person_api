package dio.personapi.utils;

import dio.personapi.dto.request.EmailDTO;
import dio.personapi.entity.Email;
import dio.personapi.enums.EmailTipo;

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
