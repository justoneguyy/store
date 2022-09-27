package de.szut.store.supplier;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public SupplierEntity create(SupplierEntity newSupplier) {
        return repository.save(newSupplier);
    }

    public List<SupplierEntity> readAll() {
        return repository.findAll();
    }

    public SupplierEntity readById(long id) {
        Optional<SupplierEntity> oSupplierEntity = repository.findById(id);
        return oSupplierEntity.orElse(null);
    }

    public SupplierEntity update(SupplierEntity supplier) {
        SupplierEntity updatedSupplier = readById(supplier.getSid());
        updatedSupplier.setName(supplier.getName());
        updatedSupplier.getContact().setStreet(supplier.getContact().getStreet());
        updatedSupplier.getContact().setPostcode(supplier.getContact().getPostcode());
        updatedSupplier.getContact().setCity(supplier.getContact().getCity());
        updatedSupplier.getContact().setPhone(supplier.getContact().getPhone());
        updatedSupplier = this.repository.save(updatedSupplier);
        return updatedSupplier;
    }

    public void delete(long id) {
        repository.delete(id);
    }
}
