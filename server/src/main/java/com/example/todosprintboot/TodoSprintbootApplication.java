package com.example.todosprintboot;

//import com.example.todosprintboot.model.TodoItem;
import com.example.todosprintboot.model.TodoItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class TodoSprintbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoSprintbootApplication.class, args);
	}

	@GetMapping
	public List<TodoItem> hello(){
		return List.of(new TodoItem(1L,"todo",false));
	}

}
