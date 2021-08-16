package dio.personapi.personapi.entity;

import dio.personapi.personapi.enums.EmailTipo;
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
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmail;

    @Enumerated(EnumType.STRING)
    private EmailTipo emailTipo;

    private String email;

}
