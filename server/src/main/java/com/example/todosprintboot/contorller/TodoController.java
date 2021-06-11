package com.example.todosprintboot.contorller;


import com.example.todosprintboot.model.TodoItem;
import com.example.todosprintboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
@CrossOrigin("http:localhost:3000")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getTodoItems() {
        return ResponseEntity.ok().body(todoService.getTodoItems());
        //= ResponseEntity.ok(todoService.getTodoItems())
        //= ResponseEntity.status(HttpStatus.OK).body(todoItems)
    }

    @GetMapping("{id}")
    public TodoItem getTodoItemById(@PathVariable long id) {
        return todoService.getTodoItemById(id);
    }

    @PostMapping
    public void createTodoItem(@RequestBody TodoItem todoItem) {
        todoService.createTodoItem(todoItem);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoItem> updateProduct(@PathVariable long id,
                                                  @RequestBody TodoItem todoItem) {
        todoItem.setId(id);
        return ResponseEntity.ok().body(todoService.updateTodoItem(todoItem));
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteProduct(@PathVariable long id){
        todoService.deleteTodoItem(id);
        return HttpStatus.OK;
    }

}
