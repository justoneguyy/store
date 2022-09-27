package de.szut.store.contact;

import de.szut.store.supplier.SupplierEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="supplier_contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String street;
    private String postcode;
    private String city;
    private String phone;

    // Associations
    @OneToOne (
                mappedBy = "contact",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL
              )
    private SupplierEntity supplier;
}
