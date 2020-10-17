package pl.coderslab.web;

import pl.coderslab.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getList();
    Book returnBook(Long id);
    String addBook(Book book);
    void updateBook(Long id, Book book);
    void deleteBook(Long id);
}
