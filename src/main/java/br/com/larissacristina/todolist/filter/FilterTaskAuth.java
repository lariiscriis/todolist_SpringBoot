package br.com.larissacristina.todolist.filter;

import jakarta.servlet.FilterChain;
import java.io.IOException;
import jakarta.servlet.ServletException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.larissacristina.todolist.user.IUserRepository;

@Component // indica que o spring gerencia a classe
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var servletPath = request.getServletPath();

        // verificar se a rota é /tasks
        if (servletPath.startsWith("/tasks/")) {
            // pegar autenticacao
            var authorization = request.getHeader("Authorization");

            // decode do base, substring remove o "Basic" e trim remove os espaços
            var authEncoded = authorization.substring("Basic".length()).trim();

            // decode do base64, conversão para bytes e decodificação
            byte[] authDecode = Base64.getDecoder().decode(authEncoded);

            // conversão de bytes para string
            var authString = new String(authDecode);

            // separar username e password: ["lariiscriis"(credentials 0) ,"123"(credentials
            // 1)]
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // validar user
            var user = this.userRepository.findByUsername(username);

            if (user == null) {
                response.sendError(401);
            } else {
                // - Validar Senha

                // verificação de senha com a hash do banco de dados
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

                if (passwordVerify.verified) {
                    request.setAttribute("idUser", user.getId()); // passar o id do usuário para o controller
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }

            }
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
