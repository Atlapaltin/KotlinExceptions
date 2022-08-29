package ru.netology

object WallService {
    private var curId: Long = 1
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(postId: Long, comment: Comment): Comment? {
        val curPost = findPostById(postId)
        if(curPost != null) {
            comments += comment
            return comment
        } else {
            throw PostNotFoundException("No post with id = $postId")
        }
        return null
    }

    fun add(post: Post): Post {
        post.id = curId
        posts += post
        curId ++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var result = false
        for(ps in posts) {
            if(ps.id == post.id) {
                ps.fromId = post.fromId
                ps.createdBy = post.createdBy
                ps.text = post.text
                ps.replyOwnerId = post.replyOwnerId
                ps.friendsOnly = post.friendsOnly
                ps.comments = post.comments
                ps.copyright = post.copyright
                ps.likes = post.likes
                ps.reposts = post.reposts
                ps.views  = post.views
                ps.postType = post.postType
                ps.signerId = post.signerId
                ps.canPin = post.canPin
                ps.canDelete = post.canDelete
                ps.canEdit = post.canEdit
                ps.isPinned = post.isPinned
                ps.markedAsAds = post.markedAsAds
                ps.isFavorite = post.isFavorite
                ps.postponedId = post.postponedId
                result = true
            }
        }
        return result
    }

    fun likeById(id: Long) {
        for((index, post) in posts.withIndex()) {
            if(post.id == id){
                posts[index] = post.copy(
                    likes = post.likes.copy(
                        count = post.likes.count + 1
                    )
                )
            }
        }
    }

    fun findPostById(postId: Long): Post? {
        for(post in posts){
            if(post.id == postId) {
                return post
            }
        }
        return null
    }

    fun addAttachment(postId: Long, attachment: Attachment) {
        for((index, post) in posts.withIndex()) {
            if(post.id == postId){
                posts[index] = post.copy(
                    attachment = post.attachment + attachment
                )
            }
        }
    }
}