package org.technyx.icm.controller;//package org.technyx.icm.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.technyx.icm.model.dtos.PermissionDto;
//import org.technyx.icm.model.service.interfaces.PermissionService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/app/v001/permission")
//public class PermissionController {
//    @Autowired
//    private PermissionService service;
//
//    @PostMapping
//    public ResponseEntity<String> save(@RequestBody PermissionDto dto) {
//        ResponseEntity<String> response = null;
//        try {
//            PermissionDto savedDto = service.save(dto);
//            if (savedDto != null) {
//                response = ResponseEntity
//                        .status(HttpStatus.CREATED)
//                        .body("given permission has been created");
//            }
//        } catch (Exception ex) {
//            response = ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("an exception occurred due to " + ex.getMessage());
//        }
//        return response;
//    }
//
//    @PutMapping
//    public ResponseEntity<String> update(@RequestBody PermissionDto dto) {
//        ResponseEntity<String> response = null;
//        try {
//            PermissionDto updatedDto = service.update(dto);
//            if (updatedDto != null) {
//                response = ResponseEntity
//                        .status(HttpStatus.CREATED)
//                        .body("given permission has been updated");
//            }
//        } catch (Exception ex) {
//            response = ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("an exception occurred due to " + ex.getMessage());
//        }
//        return response;
//    }
//
//    @DeleteMapping
//    public ResponseEntity<String> delete(@RequestBody PermissionDto dto) {
//        ResponseEntity<String> response = null;
//        try {
//            service.delete(dto);
//            response = ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body("given permission has been deleted");
//
//        } catch (Exception ex) {
//            response = ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("an exception occurred due to " + ex.getMessage());
//        }
//        return response;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<PermissionDto>> showAll() {
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(service.showList());
//    }
//}
