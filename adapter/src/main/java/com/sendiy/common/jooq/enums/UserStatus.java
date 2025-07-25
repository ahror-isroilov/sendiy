/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq.enums;


import com.sendiy.common.jooq.Public;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum UserStatus implements EnumType {

    ACTIVE("ACTIVE"),

    BLOCKED("BLOCKED"),

    DISABLED("DISABLED");

    private final String literal;

    private UserStatus(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public String getName() {
        return "user_status";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal. Returns
     * <code>null</code>, if no such value could be found, see {@link
     * EnumType#lookupLiteral(Class, String)}.
     */
    public static UserStatus lookupLiteral(String literal) {
        return EnumType.lookupLiteral(UserStatus.class, literal);
    }
}
