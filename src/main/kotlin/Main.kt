package ru.netology

fun main() {
    val post1 =  Post(
        id = 0,
        ownerId = 1,
        text = "New post",
        date = 1663718400,
        likes = Likes(count = 22),
        attachment = arrayOf(
            PhotoAttachment(),
            VideoAttachment(),
            WikiAttachment()
        )
    )

    val post2 =  Post(
        id = 0,
        ownerId = 1,
        text = "One more post",
        date = 1663718400,
        likes = Likes(count = 22)
    )

    post1.attachment.forEach { println(it) }
    val service = WallService
    val added1 = service.add(post1)
    val added2 = service.add(post2)
    service.addAttachment(added2.id, PhotoAttachment())
    val postWithAttachment = service.findPostById(added2.id)

    println("postWithAttachment: $postWithAttachment")
    println("added1: $added1")

     val post3 =  Post(
        id = 2,
        ownerId = 1,
        text = "Another post",
        date = 1663718400,
        likes = Likes(count = 22)
    )

    val res = service.update(post3)
    println("Post updated: $res")
    val comment = Comment(id = 1, text = "Comment for post 1")
    val commentedPost1 = service.createComment(1,comment)
    println(commentedPost1)
    val commentedPost2 = service.createComment(15,comment)
}