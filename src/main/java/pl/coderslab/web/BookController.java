package pl.coderslab.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.domain.Book;
import pl.coderslab.domain.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memoryBookService;

    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> returnBooksList() {
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book book(@PathVariable Long id) {
        return memoryBookService.returnBook(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @PostMapping("")
    public String addBook(@RequestBody Book book) {
        return memoryBookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        memoryBookService.deleteBook(id);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        memoryBookService.updateBook(book);
    }
}


