package com.example.simplesearch

data class APIResponse (
    val status: String,
    val totalResults: Long,
    val articles: List<Article>
)

data class Article (
    val source: Source,
    val author: String? = null,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String? = null
)

data class Source (
    val id: String? = null,
    val name: String
)
