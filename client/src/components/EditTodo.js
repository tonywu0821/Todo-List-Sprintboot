import React, { useState } from "react";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './InputTodo.css';

const EditTodo = ({ todo , updateTodo}) => {
  const [content, setContent] = useState(todo.content);

  const editHandler = e => {
    if(content.length === 0){      
      toast("You must enter at least one character!");
      return;
    }
    updateTodo(todo.id, content, todo.done)
  }
  
  return (
    <>
      <button
        type="button"
        class="btn btn-warning"
        data-toggle="modal"
        data-target={`#id${todo.id}`}
      >
        Edit
      </button>

      <div
        class="modal"
        id={`id${todo.id}`}
        onClick={() => setContent(content)}
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title text-dark ">Edit Todo</h4>
              <button
                type="button"
                class="close"
                data-dismiss="modal"
                onClick={() => setContent(content)}
              >
                &times;
              </button>
            </div>

            <div class="modal-body">
              <input
                type="text"
                className="form-control"
                value={content}
                onChange={e => setContent(e.target.value)}
              />
            </div>

            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-warning"
                data-dismiss="modal"
                onClick={editHandler}
              >
                Edit
              </button>
              <button
                type="button"
                class="btn btn-danger"
                data-dismiss="modal"
                onClick={() => setContent(content)}
              >
                Close
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default EditTodo;