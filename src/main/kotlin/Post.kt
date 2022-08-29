package ru.netology

data class Post(
    var id: Long = 0,
    var ownerId: Long = 0,
    var fromId: Long = 0,
    var createdBy: Long = 0,
    var date: Long = 0,
    var text: String = "no-text",
    var replyOwnerId: Long = 0,
    var replyPostId: Long = 0,
    var friendsOnly: Boolean = false,
    var comments: Comments = Comments(),
    var copyright: String = "",
    var likes: Likes = Likes(),
    var reposts: Reposts = Reposts(),
    var views: Views = Views(),
    var postType: PostType = PostType.POST,
    var postSource: PostSource = PostSource(),
    var authorName: String = "",

    @Suppress("ArrayInDataClass")
    var attachment: Array<Attachment> = emptyArray(),

    var signerId: Int = 0,
    var canPin: Boolean = false,
    var canDelete: Boolean = false,
    var canEdit: Boolean = false,
    var isPinned: Boolean = false,
    var markedAsAds: Boolean = false,
    var isFavorite: Boolean = false,
    var postponedId: Int = 0
)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Likes(
    var count: Int = 0,
    var userLikes: Boolean =false,
    var canLike: Boolean =false,
    var canPublish: Boolean = false
)

data class Reposts(
    var count: Int = 0,
    var userReposted: Boolean = false
)

data class Views(
    var count: Int = 0
)

enum class PostType {
    POST
}

data class PostSource(
    val type: PostSourceType = PostSourceType.VK,
    val data: String? = null,
    val platform: Platform = Platform.ANDROID
)

enum class PostSourceType {
    VK
}

enum class Platform{
    ANDROID
}