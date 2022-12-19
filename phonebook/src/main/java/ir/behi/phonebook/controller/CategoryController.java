package ir.behi.phonebook.controller;

import ir.behi.phonebook.dto.CategoryDTO;
import ir.behi.phonebook.exception.ServiceException;
import ir.behi.phonebook.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Integer id) throws ServiceException {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/getAllByPaging")
    public ResponseEntity getAllByPaging(@RequestParam Pageable pageable) {
        return ResponseEntity.ok(categoryService.findAllByPaging((pageable)));
    }

    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam Integer id) throws ServiceException {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Validated CategoryDTO category) {
        return ResponseEntity.ok(categoryService.insert(category));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid CategoryDTO category) {
        return ResponseEntity.ok(categoryService.update(category));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws ServiceException {
        return ResponseEntity.ok(categoryService.delete(id));
    }
}
