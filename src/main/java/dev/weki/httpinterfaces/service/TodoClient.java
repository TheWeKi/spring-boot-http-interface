package dev.weki.httpinterfaces.service;

import dev.weki.httpinterfaces.model.Todo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface TodoClient {

    @GetExchange("/todos")
    List<Todo> getAllTodos();

    @GetExchange("/todos/{id}")
    Todo getTodoById(@PathVariable Integer id);

    @PostExchange("/todos")
    void createTodo(@RequestBody Todo todo);

    @PutExchange("/todos/{id}")
    void updateTodoById(@PathVariable Integer id, @RequestBody Todo todo);

    @DeleteExchange("/todos/{id}")
    void deleteTodoById(@PathVariable Integer id);

}
