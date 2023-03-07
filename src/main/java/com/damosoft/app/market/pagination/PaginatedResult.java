package com.damosoft.app.market.pagination;

import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginatedResult {
    private QueryOptions options;
    private int count;
    private Long totalCount;
    private List<?> entries;

    public Response toResponse() {
        return Response.ok(this).build();
    }
}
