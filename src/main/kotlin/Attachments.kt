package ru.netology

interface Attachment {
    val type: String
}

data class PhotoAttachment(val photo: Photo = Photo()) : Attachment {
    override val type: String = "photo"
    data class Photo(
        val id: Long = 0,
        val albumId: Long = 0,
        val ownerId: Long = 0,
        val userId: Long = 0
    )
}

data class VideoAttachment(val video: Video = Video()) : Attachment {
    override val type: String = "video"
    data class Video(
        val id: Long = 0,
        val albumId: Long = 0,
        val ownerId: Long = 0,
        val userId: Long = 0
    )
}

data class WikiAttachment(val wiki: Wiki = Wiki()) : Attachment {
    override val type: String = "wiki"
    data class Wiki(
        val id: Long = 0,
        val groupId: Long = 0,
        val title: String = ""
    )
}

data class EventAttachment(val event: Event = Event()): Attachment {
    override val type: String = "event"
    data class Event(
        val id: Long = 0,
        val time: Int = 0,
        val memberStatus: Int = 0,
        val isFavorite: Boolean = false,
        val address: String = "",
        val text: String = "",
        val buttonText: String = ""
    )
}

data class GraffitiAttachment(val graffity: Graffiti = Graffiti()) : Attachment {
    override val type: String = "graffiti"
    data class Graffiti(
        val id: Long = 0,
        val ownerId: Long = 0,
        val photo130: String = "",
        val photo604: String = ""
    )
}