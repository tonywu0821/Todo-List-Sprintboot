import React, { useState, useEffect, useRef } from 'react';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './InputTodo.css';

const InputTodo = ({ addTodo }) => {
  const [content, setCotent] = useState("");

  const inputRef = useRef(null);

  useEffect(() => {
    inputRef.current.focus();
  });

  const submitHandler = async e => {
    e.preventDefault();
    if(content.length === 0){
      toast("You must enter a least one character!");
      return;
    }
    addTodo(content);
    setCotent("");
  };

  return (
    <>
      <form className="todo-form">
        <input
          placeholder="Add a todo"
          value={content}
          onChange={e => setCotent(e.target.value)}
          name="text"
          className="todo-input"
          ref={inputRef}
        />
        <button onClick={submitHandler} className="todo-button">
          Add todo
        </button>
      </form>
    </>
  )
}
export default InputTodo
