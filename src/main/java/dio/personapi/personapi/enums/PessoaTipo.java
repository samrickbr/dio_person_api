package dio.personapi.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PessoaTipo {

    FISICA("Fisica"),
    JURIDICA("Juridica");

    private final String tipoPessoa;
}
