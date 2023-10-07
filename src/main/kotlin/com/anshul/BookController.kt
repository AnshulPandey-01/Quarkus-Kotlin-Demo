package com.anshul

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import java.util.ArrayList

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class BookController {

    private val books: ArrayList<Book> = ArrayList()

    @POST
    fun addBook(book: Book) : Book {
        books.add(book)
        return book
    }

    @GET
    fun getAllBooks() = books

    @GET
    @Path("/{title}")
    fun getBooksByTitle(@PathParam("title") title: String) : Book? {
        return books.find { it.title == title }
    }

}