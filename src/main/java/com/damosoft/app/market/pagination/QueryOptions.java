package com.damosoft.app.market.pagination;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

import java.util.List;

public class QueryOptions {
    @QueryParam("sort")
    private List<String> sort;
    @QueryParam("page")
    @DefaultValue("0")
    private int page;
    @QueryParam("size")
    @DefaultValue("20")
    private int pageSize;

    public QueryOptions(List<String> sort, int page, int pageSize) {
        this.sort = sort;
        this.page = page;
        this.pageSize = pageSize;
    }

    public List<String> getSort() {
        return sort;
    }

    public void setSort(List<String> sort) {
        this.sort = sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
