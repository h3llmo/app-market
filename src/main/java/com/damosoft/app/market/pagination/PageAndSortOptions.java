package com.damosoft.app.market.pagination;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public class PageAndSortOptions {
    private Page page;
    private Sort sort;

    public PageAndSortOptions(Page page, Sort sort) {
        this.page = page;
        this.sort = sort;
    }

    public Page getPage() {
        return page;
    }

    public Sort getSort() {
        return sort;
    }
}
