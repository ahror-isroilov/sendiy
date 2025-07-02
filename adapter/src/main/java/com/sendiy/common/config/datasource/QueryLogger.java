package com.sendiy.common.config.datasource;

import org.jooq.ExecuteContext;
import org.jooq.ExecuteListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author: ahror
 *
 * <p>since: 04/10/2024
 */
public class QueryLogger implements ExecuteListener {
    private static final Logger log = LoggerFactory.getLogger(QueryLogger.class);
    private long startTime;

    @Override
    public void executeStart(ExecuteContext ctx) {
        startTime = System.currentTimeMillis();
        System.out.printf("Executing query: %s\n", ctx.sql());
    }

    @Override
    public void executeEnd(ExecuteContext ctx) {
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        if (ctx.exception() != null) {
            log.error("Query failed: {}", ctx.sql(), ctx.exception());
        }
        log.debug("Query executed in {} ms: {}", duration, ctx.sql());
    }
}
