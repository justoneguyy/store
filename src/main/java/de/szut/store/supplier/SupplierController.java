package de.szut.store.supplier;

import mapping.MappingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("store/supplier")
public class SupplierController {

    private SupplierService service;
    private MappingService mappingService;

    public SupplierController(SupplierService service, MappingService mappingService) {
        this.service = service;
        this.mappingService = mappingService;
    }


    @PostMapping
    public ResponseEntity<GetSupplierDto> createSupplier(@Valid @RequestBody final AddSupplierDto dto) {
        SupplierEntity newSupplier = this.mappingService.mapAddSupplierDtoToSupplier(dto);
        newSupplier = this.service.create(newSupplier);
        final GetSupplierDto request = this.mappingService.mapSupplierToGetSupplierDto(newSupplier);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetSupplierDto>> findAllSuppliers() {
        List<SupplierEntity> all = this.service.readAll();
        List<GetSupplierDto> dtoList = new LinkedList<>();
        for (SupplierEntity supplier: all) {
            dtoList.add(this.mappingService.mapSupplierToGetSupplierDto(supplier));
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSupplierDto> getSupplierById(@PathVariable final Long id) {
        final var entity = this.service.readById(id);
        final GetSupplierDto dto = this.mappingService.mapSupplierToGetSupplierDto(entity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
