package de.szut.store.supplier;

import de.szut.store.article.ArticleEntity;
import de.szut.store.contact.ContactEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;
    private String name;

    // Associations
    @OneToOne (
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL
              )
    private ContactEntity contact;
    @OneToMany (
                mappedBy = "supplier",
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER
               )
    private Set<ArticleEntity> articles;

}
