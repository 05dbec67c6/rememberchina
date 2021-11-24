package com.rememberchina.network

import com.squareup.moshi.Json

data class ChinaEvent(
    val id: String,
    val date: String,

    // Json objects "title" has "rendered" array
    val title: WordPressTitle,
    val wordPressTitle: String = title.rendered,

    // Json objects "content" has "rendered" array
    val content: WordPressTitle,
    val wordPressContent: String = content.rendered

)

data class WordPressTitle(
    @Json(name = "rendered")
    val rendered: String
)

data class WordPressContent(
    @Json(name = "rendered")
    val rendered: String
)