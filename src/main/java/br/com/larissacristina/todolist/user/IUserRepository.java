package br.com.larissacristina.todolist.user;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface que extende a interface JpaRepository, que é responsável por realizar as operações de CRUD no banco de dados
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username); // Método que busca um usuário pelo nome de usuário
}
