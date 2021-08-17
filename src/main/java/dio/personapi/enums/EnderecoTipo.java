package dio.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnderecoTipo {

    CASA_END("Casa_end"),
    COMERCIAL_END("Comercial_end"),
    OUTRO_END("Outro_end");

    private final String descricaoEndereco;
}
