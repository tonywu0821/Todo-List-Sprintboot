package com.example.todosprintboot.service;

import com.example.todosprintboot.exception.ResourceNotFoundException;
import com.example.todosprintboot.model.TodoItem;
import com.example.todosprintboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoItem createTodoItem(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    public TodoItem updateTodoItem(TodoItem todoItem) {
        Optional<TodoItem> todoItemDb = this.todoRepository.findById(todoItem.getId());

        if (todoItemDb.isPresent()) {
            TodoItem todoItemUpdate = todoItemDb.get();
            todoItemUpdate.setId(todoItem.getId());
            todoItemUpdate.setContent(todoItem.getContent());
            todoItemUpdate.setDone(todoItem.getDone());
            todoRepository.save(todoItemUpdate);
            return todoItemUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + todoItem.getId());
        }
    }

    public List<TodoItem> getTodoItems(){
        return todoRepository.findAll();
    }

    public TodoItem getTodoItemById(long todoId){
        Optional<TodoItem> todoItemDb = this.todoRepository.findById(todoId);

        if (todoItemDb.isPresent()) {
            return todoItemDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + todoId);
        }
    }

    public void deleteTodoItem(long todoId){
        Optional<TodoItem> todoItemDb = this.todoRepository.findById(todoId);

        if (todoItemDb.isPresent()) {
            this.todoRepository.delete(todoItemDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + todoId);
        }

    }


}
