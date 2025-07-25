/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq.tables.records;


import com.sendiy.common.jooq.enums.ShopStatus;
import com.sendiy.common.jooq.tables.Shops;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ShopsRecord extends UpdatableRecordImpl<ShopsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.shops.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.shops.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.shops.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.shops.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.shops.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.shops.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.shops.status</code>.
     */
    public void setStatus(ShopStatus value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.shops.status</code>.
     */
    public ShopStatus getStatus() {
        return (ShopStatus) get(3);
    }

    /**
     * Setter for <code>public.shops.user_id</code>.
     */
    public void setUserId(UUID value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.shops.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(4);
    }

    /**
     * Setter for <code>public.shops.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.shops.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.shops.created_by</code>.
     */
    public void setCreatedBy(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.shops.created_by</code>.
     */
    public UUID getCreatedBy() {
        return (UUID) get(6);
    }

    /**
     * Setter for <code>public.shops.modified_at</code>.
     */
    public void setModifiedAt(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.shops.modified_at</code>.
     */
    public LocalDateTime getModifiedAt() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.shops.modified_by</code>.
     */
    public void setModifiedBy(UUID value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.shops.modified_by</code>.
     */
    public UUID getModifiedBy() {
        return (UUID) get(8);
    }

    /**
     * Setter for <code>public.shops.deleted_date</code>.
     */
    public void setDeletedDate(LocalDateTime value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.shops.deleted_date</code>.
     */
    public LocalDateTime getDeletedDate() {
        return (LocalDateTime) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ShopsRecord
     */
    public ShopsRecord() {
        super(Shops.SHOPS);
    }

    /**
     * Create a detached, initialised ShopsRecord
     */
    public ShopsRecord(UUID id, String name, String description, ShopStatus status, UUID userId, LocalDateTime createdAt, UUID createdBy, LocalDateTime modifiedAt, UUID modifiedBy, LocalDateTime deletedDate) {
        super(Shops.SHOPS);

        setId(id);
        setName(name);
        setDescription(description);
        setStatus(status);
        setUserId(userId);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        setModifiedAt(modifiedAt);
        setModifiedBy(modifiedBy);
        setDeletedDate(deletedDate);
        resetChangedOnNotNull();
    }
}
