package com.in28minutes.rest.services.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static long idCounter = 0L;

	static {
		todos.add(new Todo(++idCounter, "demo", "Aprender a programar angular", new Date(), false));
		todos.add(new Todo(++idCounter, "demo", "Mejorar mi forma de programar", new Date(), false));
		todos.add(new Todo(++idCounter, "demo", "Ser un experto en Spring-boot", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo save(Todo todo) {
		if (Objects.nonNull(todo)) {
			if (Objects.isNull(todo.getId()) || todo.getId() == -1l || todo.getId() == 0l) {
				todo.setId(++idCounter);
			} else {
				deleteById(todo.getId());
			}
			todos.add(todo);
		}
		return todo;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (Objects.isNull(todo)) {
			return null;
		}
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (id == todo.getId()) {
				return todo;
			}
		}
		return null;
	}
}
