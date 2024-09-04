package camelnotfemale.hellocontroller.controllers;

import camelnotfemale.hellocontroller.data.BookService;
import camelnotfemale.hellocontroller.entities.AddBookRequest;
import camelnotfemale.hellocontroller.entities.Book;
import camelnotfemale.hellocontroller.entities.mappers.BookToDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class HelloController {

    private final BookService bookService;
    private final BookToDtoMapper mapper;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String author) {
        if (author != null)
            return bookService.findByAuthor(author);

        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody AddBookRequest request) {
        bookService.addBook(mapper.AddBookRequestToBook(request));
    }
}