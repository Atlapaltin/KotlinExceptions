@file:Suppress("ArrayInDataClass")
package ru.netology

data class Comment(
    val id: Long = 0,
    val fromId: Long = 0,
    val date: Long = 0,
    val text: String = "no-text",
    val donut: Donut = Donut(),
    val replyToUser: Long = 0,

    @Suppress("ArrayInDataClass")
    val attachment: Array<Attachment> = emptyArray(),
    val parentStack: Array<Long> = emptyArray(),
    val thread: Thread = Thread()
)

data class Donut(
    val idDon: Boolean = false,
    val placeholder: String = ""
)

data class Thread(
    val count: Int = 0,
    val canPost: Boolean = false,
    val showReplyButton: Boolean = false,
    val groupsCanPost: Boolean = false
)