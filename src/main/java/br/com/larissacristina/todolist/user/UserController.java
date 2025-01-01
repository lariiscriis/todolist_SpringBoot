package br.com.larissacristina.todolist.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // Classe que representa uma resposta HTTP
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@RestController // Indica que a classe é um controller e que irá responder requisições HTTP,
                // utilizado quando se quer retornar um JSON, mais utilizado em APIs REST.
@RequestMapping("users") // Indica qual o caminho que será acessado para chamar os métodos dessa classe.
public class UserController {

    @Autowired // Indica que a injeção de dependência será feita automaticamente pelo Spring
    private IUserRepository userRepository;

    @SuppressWarnings("rawtypes")
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if (user != null) {
            System.out.println("Usuário já cadastrado");

            // Retorna uma resposta HTTP com status da requisição
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado");
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel); // Salva o usuário no banco de dados
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

}
