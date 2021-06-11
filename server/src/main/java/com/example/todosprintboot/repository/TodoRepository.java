package com.example.todosprintboot.repository;

import com.example.todosprintboot.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem,Long> {
}
