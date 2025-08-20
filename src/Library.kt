/**
 * LIBRARY CLASS: Manages book collection and recommendations
 * COMPOSITION: HAS-A list of Book objects
 * ENCAPSULATION: Internal books list is private and protected
 * STRATEGY PATTERN: Delegates recommendation logic to strategy objects
 */
class Library {
    // COMPOSITION + ENCAPSULATION: Private list of books
    private val books = mutableListOf<Book>()

    /**
     * Adds a book to the library collection
     * @param book Book object to be added
     * USAGE: library.addBook(book)
     */
    fun addBook(book: Book) {
        books.add(book)
    }

    /**
     * STRATEGY PATTERN: Gets book recommendations using specified strategy
     * POLYMORPHISM: Works with any RecommendationStrategy implementation
     * @param user User for personalized recommendations
     * @param strategy Recommendation algorithm to use (ByGenre, ByAuthor, ByRating)
     * @return List of recommended books
     * USAGE: library.recommendBooks(user, ByGenre())
     */
    fun recommendBooks(user: User, strategy: RecommendationStrategy): List<Book> {
        return strategy.recommend(user, books)
    }

    /**
     * Displays all books in the library with formatted information
     * ABSTRACTION: Hides internal iteration and formatting logic
     */
    fun showAllBooks() {
        println("\n📚 All Books in Library:")
        books.forEach {
            println("   - ${it.title} by ${it.author} [${it.genre}] ⭐${it.rating}")
        }
    }
}