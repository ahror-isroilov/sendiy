/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq;


import com.sendiy.common.jooq.tables.FlywaySchemaHistory;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex(DSL.name("flyway_schema_history_s_idx"), FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
}
