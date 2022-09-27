package de.szut.store.article;

import de.szut.store.supplier.SupplierEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @NotNull
    private Double price;
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "last_update_date", nullable = false)
    private LocalDateTime lastUpdateDate = LocalDateTime.now();

    // Associations
    @ManyToOne (
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL
               )
    private SupplierEntity supplier;
}
