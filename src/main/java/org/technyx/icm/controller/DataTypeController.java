package org.technyx.icm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technyx.icm.model.entity.DataType;
import org.technyx.icm.model.service.interfaces.DataTypeService;

import java.util.List;

@RestController
@RequestMapping("/app/v001/util/data-type")
public class DataTypeController {

    private final DataTypeService service;

    public DataTypeController(DataTypeService service) {
        this.service = service;
    }

    @GetMapping("/{discriminator}")
    public ResponseEntity<List<DataType>> showDataTypeByDiscriminator(@PathVariable String  discriminator) {
        return ResponseEntity.ok().body(service.findByDiscriminator(discriminator));
    }
}
