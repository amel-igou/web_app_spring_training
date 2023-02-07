package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TodoListController {
    private TodoRepository todoRepository;
    public TodoListController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    @PostMapping("api/todo")
    public void PostTodo(Todo todo)
    {
        this.todoRepository.save(new TodoEntity(todo.message(),todo.author()));
    }

    @GetMapping("api/todo")
    public Iterable<TodoEntity> GetTodo(){
        return this.todoRepository.findAll();
    }
}
