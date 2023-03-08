package com.damosoft.app.market.pagination;

import jakarta.ws.rs.core.Response;

import java.util.List;

public class PaginatedResult {
    private QueryOptions options;
    private int count;
    private Long totalCount;
    private List<?> entries;

    public PaginatedResult() {
    }

    public PaginatedResult(QueryOptions options, int count, Long totalCount, List<?> entries) {
        this.options = options;
        this.count = count;
        this.totalCount = totalCount;
        this.entries = entries;
    }

    public QueryOptions getOptions() {
        return options;
    }

    public void setOptions(QueryOptions options) {
        this.options = options;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<?> getEntries() {
        return entries;
    }

    public void setEntries(List<?> entries) {
        this.entries = entries;
    }

    public Response toResponse() {
        return Response.ok(this).build();
    }
}
