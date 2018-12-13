package com.htbeyond.studying.model

import javax.persistence.*

@Entity
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    var id: Long,

    @Column(name = "TITLE")
    var title: String,

    @Column(name = "CONTENT")
    var content: String = "")