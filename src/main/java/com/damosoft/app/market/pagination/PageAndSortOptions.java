package com.damosoft.app.market.pagination;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageAndSortOptions {
    private Page page;
    private Sort sort;
}
