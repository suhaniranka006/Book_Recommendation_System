/**
 * DATA CLASS: Represents a book entity with properties and automatic functionality
 * WHY: To store book data with auto-generated equals/hashCode/toString methods
 * COMPANION OBJECT: Implements factory pattern for controlled instance creation
 * ENCAPSULATION: Private counter ensures proper ID sequencing and data integrity
 */
data class Book(
    val id: Int,           // Unique identifier (auto-generated)
    val title: String,     // Book title/name
    val author: String,    // Book author name
    val genre: String,     // Book category/genre
    val rating: Double     // User rating (0.0 - 5.0)
) {
    /**
     * COMPANION OBJECT: Factory for Book instances with auto-increment ID
     * WHY: Centralize creation logic and manage internal ID counter
     * HOW: Maintains private counter, increments on each create() call
     */
    companion object {
        private var counter = 0  // Internal ID sequencer (encapsulated)

        /**
         * FACTORY METHOD: Creates Book with auto-generated ID
         * @param title Book title, author Author name, genre Book category, rating User rating
         * @return New Book instance with unique ID
         * USAGE: Book.create("Title", "Author", "Fiction", 4.5)
         */
        fun create(title: String, author: String, genre: String, rating: Double): Book {
            counter++  // Increment internal counter
            return Book(counter, title, author, genre, rating)  // Create with new ID
        }
    }
}