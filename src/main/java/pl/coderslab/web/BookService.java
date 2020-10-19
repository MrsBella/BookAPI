package pl.coderslab.web;

import pl.coderslab.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getList();
    Optional<Book> returnBook(Long id);
    String addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
}
