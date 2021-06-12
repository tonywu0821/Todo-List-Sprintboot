package com.example.todosprintboot.model;

import javax.persistence.*;

@Entity
@Table
public class TodoItem {

    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "done")
    private Boolean done;

    public TodoItem(Long id, String content, Boolean done) {
        this.id = id;
        this.content = content;
        this.done = done;
    }

    public TodoItem(String content, Boolean done) {
        this.content = content;
        this.done = done;
    }

    public TodoItem(){

    }
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getDone() {
        return done;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", done=" + done +
                '}';
    }
}
