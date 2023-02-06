package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
class TodoListController {
    ArrayList<Todo> List  = new ArrayList<>();

    @PostMapping("api/todo")
    public void PostTodo(Todo todo){
        this.List.add(todo);
    }

    @GetMapping("api/todo")
    public ArrayList GetTodo(){
        return this.List;
    }
}
