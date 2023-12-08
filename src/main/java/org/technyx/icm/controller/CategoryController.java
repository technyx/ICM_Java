package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.CategoryDto;
import org.technyx.icm.model.service.interfaces.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody CategoryDto dto) {
        ResponseEntity<String> response = null;
        try {
            CategoryDto savedDto = service.save(dto);
            if (savedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given category has been created");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CategoryDto dto) {
        ResponseEntity<String> response = null;
        try {
            CategoryDto updatedDto = service.update(dto);
            if (updatedDto != null) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given category has been updated");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody CategoryDto dto) {
        ResponseEntity<String> response = null;
        try {
            service.delete(dto);
            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("given category has been deleted");

        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("an exception occurred due to " + ex.getMessage());
        }
        return response;
    }


    @GetMapping
    public ResponseEntity<List<CategoryDto>> showAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.showList());
    }


}
