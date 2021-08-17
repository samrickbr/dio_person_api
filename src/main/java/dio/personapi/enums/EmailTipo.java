package dio.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailTipo {

    PESSOAL("Pessoal"),
    COMERCIAL("Comercial"),
    OUTRO("Outro");

    private final String descricaoEmail;
}
