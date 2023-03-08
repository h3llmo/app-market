package com.damosoft.app.market.pagination;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PageAndSortOptions {
    private Page page;
    private Sort sort;
}
