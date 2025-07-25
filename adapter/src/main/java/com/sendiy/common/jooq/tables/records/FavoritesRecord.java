/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq.tables.records;


import com.sendiy.common.jooq.tables.Favorites;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FavoritesRecord extends UpdatableRecordImpl<FavoritesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.favorites.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.favorites.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.favorites.user_id</code>.
     */
    public void setUserId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.favorites.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.favorites.product_id</code>.
     */
    public void setProductId(UUID value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.favorites.product_id</code>.
     */
    public UUID getProductId() {
        return (UUID) get(2);
    }

    /**
     * Setter for <code>public.favorites.added_at</code>.
     */
    public void setAddedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.favorites.added_at</code>.
     */
    public LocalDateTime getAddedAt() {
        return (LocalDateTime) get(3);
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
     * Create a detached FavoritesRecord
     */
    public FavoritesRecord() {
        super(Favorites.FAVORITES);
    }

    /**
     * Create a detached, initialised FavoritesRecord
     */
    public FavoritesRecord(Long id, UUID userId, UUID productId, LocalDateTime addedAt) {
        super(Favorites.FAVORITES);

        setId(id);
        setUserId(userId);
        setProductId(productId);
        setAddedAt(addedAt);
        resetChangedOnNotNull();
    }
}
