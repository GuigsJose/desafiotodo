package br.com.guilhermesilva.desafiotodolist.controller;

import br.com.guilhermesilva.desafiotodolist.entity.Todo;
import br.com.guilhermesilva.desafiotodolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService service;
    //injeção via construtor
    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public List<Todo> create(@RequestBody Todo todo){
        return service.create(todo);
    }

    @GetMapping("/list")
    public List<Todo> list(){
        return service.list();
    }

    @PutMapping("/update")
    public List<Todo> updtate(@RequestBody  Todo todo){
        return service.update(todo);
    }
    @DeleteMapping("/{id}")
    public List<Todo> delete(@PathVariable("id") Long id){
        return service.delete(id);
    }
}
