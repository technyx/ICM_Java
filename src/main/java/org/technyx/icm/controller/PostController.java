package org.technyx.icm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.dtos.PostDto;
import org.technyx.icm.model.service.interfaces.PostService;

import java.util.List;
@RestController
@RequestMapping("/app/v001/post")
public class PostController {


        @Autowired
        private PostService service;

        @PostMapping
        public ResponseEntity<String> save(@RequestBody PostDto dto) {
            ResponseEntity<String> response = null;
            try {
                PostDto savedDto = service.save(dto);
                if (savedDto != null) {
                    response = ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body("given post has been created");
                }
            } catch (Exception ex) {
                response = ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("an exception occurred due to " + ex.getMessage());
            }
            return response;
        }

        @PutMapping
        public ResponseEntity<String> update(@RequestBody PostDto dto) {
            ResponseEntity<String> response = null;
            try {
                PostDto updatedDto = service.update(dto);
                if (updatedDto != null) {
                    response = ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body("given post has been updated");
                }
            } catch (Exception ex) {
                response = ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("an exception occurred due to " + ex.getMessage());
            }
            return response;
        }

        @DeleteMapping
        public ResponseEntity<String> delete(@RequestBody PostDto dto) {
            ResponseEntity<String> response = null;
            try {
                service.delete(dto);
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given post has been deleted");

            } catch (Exception ex) {
                response = ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("an exception occurred due to " + ex.getMessage());
            }
            return response;
        }

        @GetMapping
        public ResponseEntity<List<PostDto>> showAll() {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.showList());
        }

    }