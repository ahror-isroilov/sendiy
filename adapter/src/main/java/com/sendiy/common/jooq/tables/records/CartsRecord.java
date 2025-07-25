/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq.tables.records;


import com.sendiy.common.jooq.tables.Carts;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CartsRecord extends UpdatableRecordImpl<CartsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.carts.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.carts.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.carts.user_id</code>.
     */
    public void setUserId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.carts.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.carts.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.carts.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.carts.created_by</code>.
     */
    public void setCreatedBy(UUID value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.carts.created_by</code>.
     */
    public UUID getCreatedBy() {
        return (UUID) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CartsRecord
     */
    public CartsRecord() {
        super(Carts.CARTS);
    }

    /**
     * Create a detached, initialised CartsRecord
     */
    public CartsRecord(Long id, UUID userId, LocalDateTime createdAt, UUID createdBy) {
        super(Carts.CARTS);

        setId(id);
        setUserId(userId);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        resetChangedOnNotNull();
    }
}
