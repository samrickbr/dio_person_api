package dio.personapi.personapi.entity;

import dio.personapi.personapi.enums.TelefoneTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTelefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TelefoneTipo telefoneTipo;

    @Column(nullable = false)
    private String numero;

}
