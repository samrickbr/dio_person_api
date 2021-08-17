package dio.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TelefoneTipo {

    CASA("Casa"),
    CELULAR("Celular"),
    COMERCIAL("Comercial"),
    RECADO("Recado");

    private final String descricaoTelefone;

}
