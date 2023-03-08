package com.damosoft.app.market.pagination;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import java.util.List;

public final class PanacheQueryHelper {
    /**
     * Return a pair with key as the current page and value as the sort options
     *
     * @param options
     * @return Pair(io.quarkus.panache.common.Page, io.quarkus.panache.common.Sort) </io.quarkus.panache.common.Page,>
     */
    public static PageAndSortOptions get(QueryOptions options) {
        final Page p = Page.of(options.getPage(), options.getPageSize());
        final Sort s = Sort.empty();
        List<String> sortQuery = options.getSort();

        for (String value : sortQuery) {
            Sort n = null;
            final String[] sort = value.split(" ");
            Sort.Direction d = null;
            if (sort.length == 1 || "asc".equalsIgnoreCase(sort[1])) {
                d = Sort.Direction.Ascending;
            } else {
                d = Sort.Direction.Descending;
            }

            s.and(sort[0], d);
        }

        return new PageAndSortOptions(p, s);
    }
}
