package com.example.lifecycle.view

data class Repository(
    val repository_name: String,
    val repository_owner: String,
    val number_of_starts: Int,
    val repository_has_issues: Boolean
)