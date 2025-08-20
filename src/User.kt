/**
 * DATA CLASS: Represents a library user with reading preferences
 * COMPOSITION: HAS-A preferred genre and author for recommendations
 * WHY: To store user data and personalize book suggestions
 */
data class User(
    val id:Int,                    // Unique user identifier
    val name: String,              // User's name
    val preferredGenre:String,     // Favorite book category
    val preferredAuthor:String     // Favorite author
)

/**
 * INTERFACE: Strategy pattern contract for recommendation algorithms
 * POLYMORPHISM: Multiple implementations can be interchanged
 * ABSTRACTION: Hides specific recommendation logic from clients
 */
interface RecommendationStrategy {
    /**
     * Recommends books based on specific strategy
     * @param user User with preferences, books Available books list
     * @return Filtered and sorted list of recommended books
     */
    fun recommend(user:User,books: List<Book>) : List<Book>
}

/**
 * STRATEGY IMPLEMENTATION: Recommends books by user's preferred genre
 * FILTERS: Books matching user's preferred genre (case-insensitive)
 * SORTS: By rating descending (highest rated first)
 */
class ByGenre : RecommendationStrategy {
    override fun recommend(user: User, books: List<Book>): List<Book> {
        return books.filter { it.genre.equals(user.preferredGenre,ignoreCase = true) }
            .sortedByDescending { it.rating }
    }
}

/**
 * STRATEGY IMPLEMENTATION: Recommends books by overall rating
 * FILTERS: No filtering - considers all books
 * SORTS: By rating descending (highest rated books first)
 * USAGE: For new users or when personalized data is unavailable
 */
class ByRating:RecommendationStrategy {
    override fun recommend(user: User, books: List<Book>): List<Book> {
        return books.sortedByDescending { it.rating }
    }
}

/**
 * STRATEGY IMPLEMENTATION: Recommends books by user's favorite author
 * FILTERS: Books by user's preferred author (case-insensitive)
 * SORTS: By rating descending (highest rated books first)
 */
class ByAuthor : RecommendationStrategy {
    override fun recommend(user: User, books: List<Book>): List<Book> {
        return books.filter { it.author.equals(user.preferredAuthor,ignoreCase = true) }
            .sortedByDescending { it.rating }
    }
}