package com.htbeyond.studying.controller

import com.htbeyond.studying.model.Todo
import com.htbeyond.studying.repository.TodoRepository
import com.htbeyond.studying.service.TestClientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/basic")
class TodoContorller(private val todoRepository: TodoRepository, private val testClientService: TestClientService) {

    @PostMapping("/todos")
    fun createTodo(@Valid @RequestBody todo: Todo) = todoRepository.save(todo)

    @GetMapping("/todos/{todoId}")
    fun getTodoById(@PathVariable("todoId") todoId: Long): ResponseEntity<Todo> {
        return todoRepository.findById(todoId).map { todo ->
            ResponseEntity.ok(todo)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/todos/all")
    fun getAlltodo() = todoRepository.findAll()

    @PutMapping("/todos/{todoId}")
    fun updateTodoById(@PathVariable("todoId") todoId: Long, @Valid @RequestBody newTodo: Todo): ResponseEntity<Todo> {
        return todoRepository.findById(todoId).map { existingTodo ->
            val updatedTodo: Todo = existingTodo.copy(title = newTodo.title, content = newTodo.content)
            ResponseEntity.ok().body(todoRepository.save(updatedTodo))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/todos/{todoId}")
    fun deleteTodoById(@PathVariable("todoId") todoId: Long): ResponseEntity<Void> {
        return todoRepository.findById(todoId).map { todo ->
            todoRepository.delete(todo)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/test")
    fun test(): ResponseEntity<Map<String, String>> {
        return ResponseEntity.ok(testClientService.getTestInfo())
    }

}