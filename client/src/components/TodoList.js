import React, { useEffect, useState } from "react";
import InputTodo from "./InputTodo";

import TodoItem from './TodoItem'

const TodoList = () => {
  const [todos, setTodos] = useState([]);
  const [filter, setFilter] = useState("");

  const getTodos = async () => {
    try {
      const response = await fetch("http://localhost:8080/todo");
      const jsonData = await response.json();
      setTodos(jsonData);
      //console.log(jsonData);
    } catch (err) {
      console.error(err.message);
    }
  };

  const addTodo = async (content) => {
    try {
      const body = { content, done:false };
      const response = await fetch("http://localhost:8080/todo", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
      });
      const newTodo = await response.json()
      const newTodos = [newTodo, ...todos];
      setTodos(newTodos);
    } catch (err) {
      console.error(err.message);
    }
  }

  const updateTodo = async (id, content, done) => {
    try {
      console.log("updateTodoItem:",{id, content, done});
      const response = await fetch(
        `http://localhost:8080/todo/${id}`,
        {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({id,content,done})
        }
      );
      //const jsonData = await response.json();
      //console.log("response",jsonData);
      let updatedTodos = todos.map(todo => {
        if (todo.id === id) {
          todo.content = content;
          todo.done = done;
        }
        return todo;
      });
      setTodos(updatedTodos);

    } catch (err) {
      console.error(err.message);
    }
  }

  const deleteTodo = async id => {
    try {
      const response = await fetch(`http://localhost:8080/todo/${id}`, {
        method: "DELETE"
      });
      //const jsonData = await response.json();
      //console.log("response",jsonData);
      setTodos(todos.filter(todo => todo.id !== id));
    } catch (err) {
      console.error(err.message);
    }
  };

  function filterTodos() {
    if (filter === "") {
      return todos;
    } else if (filter === "completed"){
      return todos.filter(todo => todo.done)
    } else {
      return todos.filter(todo => !todo.done)
    }
  }

  useEffect(() => {
    getTodos();
  }, []);

  return (
    <>
      <div className="todo-top">
        <InputTodo addTodo={addTodo}/>
        <select className="todo-select" value={filter} onChange={(e) => setFilter(e.target.value)}>
          <option value="">ALL</option>
          <option value="completed">Compeleted</option>
          <option value="uncompeleted">Uncompeleted</option>
        </select>
      </div>
      
      {filterTodos().map((todo) =>
        <TodoItem key={todo.id} todo={todo} updateTodo = {updateTodo} deleteTodo={deleteTodo}/>
      )}
    </>
  )
}

export default TodoList
