package dev.weki.httpinterfaces.controller;

import dev.weki.httpinterfaces.model.Todo;
import dev.weki.httpinterfaces.service.TodoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoClient todoClient;

    @Autowired
    public TodoController(TodoClient todoClient) {
        this.todoClient = todoClient;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodos() {
        return todoClient.getAllTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo getTodoById(@PathVariable Integer id) {
        return todoClient.getTodoById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodoById(@PathVariable Integer id) {
        todoClient.deleteTodoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTodoById(@RequestBody Todo todo) {
        todoClient.createTodo(todo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTodoById(@PathVariable Integer id, @RequestBody Todo todo) {
        todoClient.updateTodoById(id, todo);
    }
}
