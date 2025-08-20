# 📚 Project: Library Book Recommendation System

## 💡Overview
This Kotlin project recommends books to users based on their preferences. 
It demonstrates OOPs concepts, Strategy Pattern, Kotlin idioms, and Collections.

## 💡OOP Concepts Used
1. **Class & Data Class** - Represent Book, User entities
2. **Polymorphism** - Different recommendation strategies
3. **Strategy Pattern** - Recommendation logic decoupled from Library
4. **Companion Object** - Unique IDs for books
5. **Kotlin Collections** - filter, map, sort for recommendations
6. **copy() function** - Duplicate/modify Book objects easily

## 💡UML Class Diagram
classDiagram

    class Book {
        - id: Int
        - title: String
        - author: String
        - genre: String
        - rating: Double
    }

    class User {
        - id: Int
        - name: String
        - preferredGenre: String
        - preferredAuthor: String
    }

    class Library {
        - books: MutableList<Book>
        + recommendBooks(user: User, strategy: RecommendationStrategy): List<Book>
        + addBook(book: Book): Unit
    }

    class RecommendationStrategy {
        <<interface>>
        + recommend(user: User, books: List<Book>): List<Book>
    }

    class ByGenre
    class ByAuthor
    class ByRating

    Library --> RecommendationStrategy
    RecommendationStrategy <|.. ByGenre
    RecommendationStrategy <|.. ByAuthor
    RecommendationStrategy <|.. ByRating


## 💡How the Program Works
1. Create Book objects → add to Library
2. Create User objects → store preferences
3. Call Library.recommendBooks(user, strategy)
4. Strategy selects relevant books
5. Display recommended books

## 💡Sample Run
📚 All Books in Library:
   - harry potter by J.K Rowling [Fantasy] ⭐4.9
   - The Hobbit by J.R.R. Tolkien [Fantasy] ⭐4.8
   - Percy Jackson by Rick Riordan [Fantasy] ⭐4.7
   - Clean Code by Robert C. Martin [Programming] ⭐4.9
   - Effective Java by Joshua Bloch [Programming] ⭐4.8
   - Kotlin in Action by Dmitry Jemerov [Programming] ⭐4.7

 Recommended Books for Kavisha (Genre: Fantasy):
1.harry potter by J.K Rowling [Fantasy Rating: 4.9
2.The Hobbit by J.R.R. Tolkien [Fantasy Rating: 4.8
3.Percy Jackson by Rick Riordan [Fantasy Rating: 4.7

 Recommended Books for Kavisha (Author : J.K Rowling):
1,harry potter by J.K Rowling [Fantasy] Rating: 4.9

 Recommended Top Rated Books:
1.harry potter by J.K Rowling [Fantasy] Rating: 4.9
2.Clean Code by Robert C. Martin [Programming] Rating: 4.9
3.The Hobbit by J.R.R. Tolkien [Fantasy] Rating: 4.8


## 💡Future Enhancements
- Add rating thresholds for recommendation
- Allow multiple strategies combined
- Store book catalog in a database
- Add a simple Android app interface
