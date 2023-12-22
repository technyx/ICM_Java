package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technyx.icm.model.entity.DataType;
import org.technyx.icm.model.service.interfaces.DataTypeService;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/util/data-type")
public class DataTypeController {

    private final DataTypeService service;

    public DataTypeController(DataTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DataType> save(DataType model) {
        return ResponseEntity.ok().body(service.save(model));
    }

    @PutMapping
    public ResponseEntity<DataType> update(long id, DataType model) {
        return ResponseEntity.ok().body(service.update(id, model));
    }

    @DeleteMapping
    public ResponseEntity<DataType> delete(long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{discriminator}")
    public ResponseEntity<List<DataType>> showDataTypeByDiscriminator(@PathVariable String discriminator) {
        return ResponseEntity.ok().body(service.findByDiscriminator(discriminator));
    }
}
