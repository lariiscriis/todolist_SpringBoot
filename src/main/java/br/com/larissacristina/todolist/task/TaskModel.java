package br.com.larissacristina.todolist.task;

import java.util.UUID;
import java.time.LocalDateTime;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id; /* id da tarefa */
    private String description; /* Descrição da tarefa */

    @Column(length = 50) /* Limitação de caracteres no campo titulo */
    private String title; /* Titulo da tarefa */
    private LocalDateTime startAt; /* Data de Inicio */
    private LocalDateTime endAt; /* Data de Término */
    private String priority; /* Prioridade da tarefa */

    @CreationTimestamp
    private LocalDateTime createdAt; /* Data que a tarefa foi criada */

    private UUID idUser; /* id do usuário que criou a tarefa */

    public void setTitle(String title) throws Exception{
        if(title.length()> 50){
            throw new Exception("O campo title de conter no maximo 50 caracteres");
        }
        this.title = title;

    }
}
