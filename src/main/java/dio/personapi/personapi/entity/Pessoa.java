package dio.personapi.personapi.entity;

import dio.personapi.personapi.enums.PessoaTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Envia a solicitação de geração e sequencia para o BD*/
    private Long idPessoa;

    @Column(nullable = false) /* define o campo como obrigatório*/
    private String nomePessoa;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PessoaTipo pessoaTipo;

    @Column(nullable = false, unique = true) /* Além de obrigatório, define o campo como valor único*/
    private String documento;

    private LocalDate dataNascimento;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Endereco> endereco;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Telefone> telefone;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Email> email;
}
