package ir.behi.library.controller;

import ir.behi.library.dto.CategoryDTO;
import ir.behi.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 01:07 PM
 **/
@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public ResponseEntity addCategory(@RequestBody @Valid CategoryDTO category) throws Exception {
        try {
            return ResponseEntity.ok().body(service.create(category));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @PutMapping(value = "/update")
    public ResponseEntity updateCategory(@RequestBody CategoryDTO category) throws Exception {
        return ResponseEntity.ok(service.update(category));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/get")
    public ResponseEntity searchCategory(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity category() throws Exception {
        return ResponseEntity.ok(service.getAll());
    }

}
