package ir.behi.library.controller;

import ir.behi.library.dto.BookDTO;
import ir.behi.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 01:00 PM
 **/
@RestController
@RequestMapping(value = "/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity addBook(@RequestBody BookDTO book) throws Exception {
        try {
            return ResponseEntity.ok().body(bookService.create(book));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/get")
    public ResponseEntity searchBook(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(bookService.get(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity selectBook() throws Exception {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateBook(@RequestBody BookDTO book) throws Exception {
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(bookService.delete(id));
    }
}

