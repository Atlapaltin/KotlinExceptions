import org.junit.Test
import org.junit.Assert.*
import ru.netology.*

class WallServiceTest {
    @Test
    fun add() {
        val post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Test text",
            date = 1663718400,
            likes = Likes(count = 22)
        )
        val service = WallService
        val added1 = service.add(post1)
        assertNotEquals(0,added1.id)
    }

    @Test
    fun updateExistId() {
        val post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Test text",
            date = 1663718400,
            likes = Likes(count = 22)
        )

        val postNew =  Post(
            id = 1,
            ownerId = 1,
            text = "New test",
            date = 1663718400,
            likes = Likes(count = 22)
        )
        val service = WallService
        val result = service.update(postNew)
        assertEquals(true, result)
    }

    @Test
    fun updateDoesNotExistId() {
        val post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Test text",
            date = 1663718400,
            likes = Likes(count = 22)
        )

        val postNew =  Post(
            id = 33,
            ownerId = 1,
            text = "New test",
            date = 1663718400,
            likes = Likes(count = 22)
        )
        val service = WallService
        val result = service.update(postNew)
        assertEquals(false, result)
    }

    @Test
    fun willNotThrow() {
        val post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Test text",
            date = 1663718400,
            likes = Likes(count = 22)
        )
        val service = WallService
        val added1 = service.add(post1)
        val comment = Comment(id = 1, text = "Comment for post 1")
        val commentedPost = service.createComment(1,comment)
        assertNotEquals(null, commentedPost)
    }

   @Test(expected = PostNotFoundException :: class)
    fun willThrow() {
        val post1 =  Post(
            id = 0,
            ownerId = 1,
            text = "Test text",
            date = 1663718400,
            likes = Likes(count = 22)
        )
        val service = WallService
        val added1 = service.add(post1)
        val comment = Comment(id = 1, text = "Comment for post 1")
        val commentedPost2 = service.createComment(15,comment)
    }
}