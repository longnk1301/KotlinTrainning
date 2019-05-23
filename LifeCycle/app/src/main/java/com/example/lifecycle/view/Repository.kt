package com.example.lifecycle.view

data class Repository(
    val repositoryName: String,
    val repositoryOwner: String,
    val numberOfStars: Int,
    val hasIssues: Boolean
)