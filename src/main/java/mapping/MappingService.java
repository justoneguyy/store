package mapping;

import de.szut.store.contact.ContactEntity;
import de.szut.store.supplier.AddSupplierDto;
import de.szut.store.supplier.SupplierEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingService {
    public SupplierEntity mapAddSupplierDtoToSupplier(AddSupplierDto dto) {
        SupplierEntity newSupplier = new SupplierEntity();
        newSupplier.setName(dto.getName());
        ContactEntity newContact = new ContactEntity();
        newContact.setStreet(dto.getStreet());
        newContact.setPostcode(dto.getPostcode());
        newContact.setCity(dto.getCity());
        newContact.setPhone(dto.getPhone());
        newSupplier.setContact(newContact);
        newContact.setSupplier(newSupplier);
        return newSupplier;
    }
}
