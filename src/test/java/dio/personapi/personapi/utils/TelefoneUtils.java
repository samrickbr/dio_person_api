package dio.personapi.personapi.utils;

import dio.personapi.personapi.dto.request.TelefoneDTO;
import dio.personapi.personapi.entity.Telefone;
import dio.personapi.personapi.enums.TelefoneTipo;

public class TelefoneUtils {

    private static final String NUMERO = "42988107610";
    private static final TelefoneTipo TELEFONE_TIPO = TelefoneTipo.CELULAR;
    private static final long ID_TELEFONE = 1L;

    public static TelefoneDTO criarFakeDTO() {
        return TelefoneDTO.builder()
                .numero(NUMERO)
                .telefoneTipo(TELEFONE_TIPO)
                .build();
    }

    public static Telefone criarFakeEntity(){
        return Telefone.builder()
                .idTelefone(ID_TELEFONE)
                .numero(NUMERO)
                .telefoneTipo(TELEFONE_TIPO)
                .build();
    }
}
