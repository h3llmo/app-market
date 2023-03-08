package com.damosoft.app.market.commands.queryorders;

import com.damosoft.app.market.entities.OrderEntity;
import com.damosoft.app.market.pagination.PageAndSortOptions;
import com.damosoft.app.market.pagination.PaginatedResult;
import com.damosoft.app.market.pagination.PanacheQueryHelper;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class QueryOrdersHandler {
    public Uni<Response> queryOrders(QueryOrders query) {
        PageAndSortOptions pair = PanacheQueryHelper.get(query);
        PaginatedResult.PaginatedResultBuilder b = PaginatedResult.builder().options(query);
        return OrderEntity
                .findAll()
                .page(pair.getPage())
                .count()
                .onItem()
                .transformToUni(totalCount -> {
                    b.totalCount(totalCount);
                    return OrderEntity
                            .findAll(pair.getSort())
                            .page(pair.getPage())
                            .list()
                            .onItem()
                            .transform(entries -> {
                                b.entries(entries);
                                b.count(entries.size());
                                return b.build().toResponse();
                            });
                });
    }
}
