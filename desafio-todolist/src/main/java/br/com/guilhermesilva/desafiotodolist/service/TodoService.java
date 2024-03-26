package br.com.guilhermesilva.desafiotodolist.service;

import br.com.guilhermesilva.desafiotodolist.entity.Todo;
import br.com.guilhermesilva.desafiotodolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository repository;
    //construtor para instanciar o repositório
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    //criação da Tarefa com retorno de todas as Tarefas
    public List<Todo> create(Todo todo){
        repository.save(todo);
        return list();
    }
    //Get de listas, sempre retornando e ordenando de forma descendente por prioridade e ascendente por nome
    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return repository.findAll(sort);
    }

    // update da lista de todo
    public List<Todo> update(Todo todo){
        repository.save(todo);
        return list();
    }

    // Deletando tarefa pelo ID
    public List<Todo> delete(Long id){
        repository.deleteById(id);
        return list();
    }

}
