package com.damosoft.app.market.commands.queryorders;

import com.damosoft.app.market.pagination.QueryOptions;

import java.util.List;

public class QueryOrders extends QueryOptions {
    public QueryOrders() {
        this(null, 0, 0);
    }

    public QueryOrders(List<String> sort, int page, int pageSize) {
        super(sort, page, pageSize);
    }
}
