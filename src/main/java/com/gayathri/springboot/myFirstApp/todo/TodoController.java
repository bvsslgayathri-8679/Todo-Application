package com.gayathri.springboot.myFirstApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


//@Controller
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=getLoggedInUsername(model);
		Todo todo=new Todo(0,username,"Default desc",LocalDate.now().plusDays(5),false);
		model.put("todo",todo);
		//model.put("todo" ->this is the actual modelAttribute="todo" in jsp page
		
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST) 
	public String addNewTodo(ModelMap model,@Valid Todo todo,BindingResult result) //for validations use @Valid
	{
		if(result.hasErrors()) {
			model.put("Size", "validation error - length min 10 characters");
			return "todo";
		}
		todoService.addTodo(getLoggedInUsername(model), todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	//description is the name of the input field
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username=getLoggedInUsername(model);
		List<Todo> todos=todoService.findByUsername(username);
		model.addAttribute("todos",todos);
		return "listTodos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//delete todo
		todoService.deletById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		//delete todo
		Todo todo=todoService.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST) 
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) //for validations use @Valid
	{
		if(result.hasErrors()) {
			model.put("Size", "validation error - length min 10 characters");
			return "todo";
		}
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
