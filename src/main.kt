
//test the code
fun main() {

    //make object of library class
    val library = Library()

    //add books
    library.addBook(Book.create("harry potter", "J.K Rowling", "Fantasy", 4.9))
    library.addBook(Book.create("The Hobbit", "J.R.R. Tolkien", "Fantasy", 4.8))
    library.addBook(Book.create("Percy Jackson", "Rick Riordan", "Fantasy", 4.7))
    library.addBook(Book.create("Clean Code", "Robert C. Martin", "Programming", 4.9))
    library.addBook(Book.create("Effective Java", "Joshua Bloch", "Programming", 4.8))
    library.addBook(Book.create("Kotlin in Action", "Dmitry Jemerov", "Programming", 4.7))


    //show all books
    library.showAllBooks()


    //create user
    val user1 = User(1, "Kavisha", preferredGenre = "Fantasy", preferredAuthor = "J.K Rowling")

    //recommend books by genre
    val genreRecommendation = library.recommendBooks(user1, ByGenre())

    println("\n Recommended Books for ${user1.name} (Genre: ${user1.preferredGenre}):")
    genreRecommendation.forEachIndexed { index, book ->
        println("${index + 1}.${book.title} by ${book.author} [${book.genre} Rating: ${book.rating}")
    }


//recommend books by author
    val authorRecommendation = library.recommendBooks(user1, ByAuthor())

    println("\n Recommended Books for ${user1.name} (Author : ${user1.preferredAuthor}):")
    authorRecommendation.forEachIndexed { index,book ->
        println("${index+1},${book.title} by ${book.author} [${book.genre}] Rating: ${book.rating}")
    }


    //recommend top rated books
    val topRatingRecommendation = library.recommendBooks(user1,ByRating())
    println("\n Recommended Top Rated Books:")
    topRatingRecommendation.take(3).forEachIndexed { index,book ->
        println("${index+1}.${book.title} by ${book.author} [${book.genre}] Rating: ${book.rating}")
    }


}