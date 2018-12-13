package com.htbeyond.studying.repository

import com.htbeyond.studying.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>