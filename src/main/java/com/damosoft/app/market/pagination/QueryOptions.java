package com.damosoft.app.market.pagination;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class QueryOptions {
    @QueryParam("sort")
    private List<String> sort;
    @QueryParam("page")
    @DefaultValue("0")
    private int page;
    @QueryParam("size")
    @DefaultValue("20")
    private int pageSize;
}
