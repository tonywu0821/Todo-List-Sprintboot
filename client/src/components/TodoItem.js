import React from 'react';
import EditTodo from "./EditTodo";

const TodoItem = ({todo, updateTodo, deleteTodo}) => {  
  return ( 
    <div 
      className={todo.done ? "complete": "todo-row"} 
    >
      <div className={todo.done ? "complete-text": "" } onClick={() => updateTodo(todo.id, todo.content, !todo.done) }>
        {todo.content}
      </div>
      <div>
      <EditTodo todo ={todo} updateTodo = {updateTodo}/>
      <button
        className="btn btn-danger"
        onClick={() => deleteTodo(todo.id)}
      >
        Delete
      </button>
      </div>
  
    </div>  
    
    
  )
}

export default TodoItem
