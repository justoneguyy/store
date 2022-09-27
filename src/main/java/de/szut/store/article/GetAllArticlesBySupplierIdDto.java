package de.szut.store.article;

import java.util.Set;

public class GetAllArticlesBySupplierIdDto {
    private Long supplierId;
    private String name;
    private Set<GetArticleDto> articles;
}
