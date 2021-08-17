package dio.personapi.personapi.utils;

import dio.personapi.personapi.dto.request.EnderecoDTO;
import dio.personapi.personapi.entity.Endereco;
import dio.personapi.personapi.enums.EnderecoTipo;

public class EnderecoUtils {

    private static final EnderecoTipo ENDERECO_TIPO = EnderecoTipo.CASA_END;
    private static final String RUA = "Rua Pio XII";
    private static final String NUMERO = "80";
    private static final String BAIRRO = "Bela Vista";
    private static final String CIDADE = "Imbaú";
    private static final String ESTADO = "Paraná";
    private static final String COMPLEMENTO = "Superior";
    private static final long ID_ENDERECO = 1L;

    public static EnderecoDTO criarFakeDTO() {
        return EnderecoDTO.builder()
                .enderecoTipo(ENDERECO_TIPO)
                .rua(RUA)
                .numero(NUMERO)
                .bairro(BAIRRO)
                .cidade(CIDADE)
                .estado(ESTADO)
                .complemento(COMPLEMENTO)
                .build();
    }

    public static Endereco criarFakeEntity() {
        return Endereco.builder()
                .idEndereco(ID_ENDERECO)
                .enderecoTipo(ENDERECO_TIPO)
                .rua(RUA)
                .numero(NUMERO)
                .bairro(BAIRRO)
                .cidade(CIDADE)
                .estado(ESTADO)
                .complemento(COMPLEMENTO)
                .build();
    }
}
