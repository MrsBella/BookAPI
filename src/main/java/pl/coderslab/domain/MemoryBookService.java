package pl.coderslab.domain;

import org.springframework.stereotype.Component;
import pl.coderslab.web.BookService;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService implements BookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	" +
                "Bates	Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann," +
                "	Gary	Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> getList() {
        return list;
    }

    public Book returnBook(Long id) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void addBook(Book book) {
        for (Book b : list) {
            if (b.getIsbn().equals(book.getIsbn())) {
                return;
            }
        }
        book.setId(nextId++);
        list.add(book);
    }

    @Override
    public void deleteBook(Long id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }
    }

    @Override
    public void updateBook(Long id, Book book) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, book);
            }
        }
    }
}