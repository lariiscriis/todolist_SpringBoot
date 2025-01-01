package br.com.larissacristina.todolist.user;

import lombok.Data;
// @Getter //indica que o Lombok deve criar automaticamente apenas os getters
// @Setter //indica que o Lombok deve criar automaticamente apenas os setters
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.util.UUID;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;

@Data // automatização dos getters e setters através do Lombok
@Entity(name = "tb_users") // indica que a classe é uma entidade do banco de dados
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID") // indica que o valor do campo será gerado automaticamente
    private UUID id;

    @Column(unique = true) // indica que o campo é único
    private String username;
    private String name;
    private String password;

    @CreationTimestamp // indica que o campo será preenchido automaticamente com a data e hora
                       // dacriação do registro
    private LocalDateTime createdAt;

}
