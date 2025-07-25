/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq.tables;


import com.sendiy.common.jooq.Keys;
import com.sendiy.common.jooq.Public;
import com.sendiy.common.jooq.tables.Carts.CartsPath;
import com.sendiy.common.jooq.tables.Products.ProductsPath;
import com.sendiy.common.jooq.tables.records.CartItemsRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CartItems extends TableImpl<CartItemsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.cart_items</code>
     */
    public static final CartItems CART_ITEMS = new CartItems();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CartItemsRecord> getRecordType() {
        return CartItemsRecord.class;
    }

    /**
     * The column <code>public.cart_items.id</code>.
     */
    public final TableField<CartItemsRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.cart_items.cart_id</code>.
     */
    public final TableField<CartItemsRecord, Integer> CART_ID = createField(DSL.name("cart_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.cart_items.product_id</code>.
     */
    public final TableField<CartItemsRecord, UUID> PRODUCT_ID = createField(DSL.name("product_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.cart_items.quantity</code>.
     */
    public final TableField<CartItemsRecord, Integer> QUANTITY = createField(DSL.name("quantity"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.cart_items.price</code>.
     */
    public final TableField<CartItemsRecord, BigDecimal> PRICE = createField(DSL.name("price"), SQLDataType.NUMERIC(10, 2).nullable(false), this, "");

    /**
     * The column <code>public.cart_items.added_at</code>.
     */
    public final TableField<CartItemsRecord, LocalDateTime> ADDED_AT = createField(DSL.name("added_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.cart_items.modified_at</code>.
     */
    public final TableField<CartItemsRecord, LocalDateTime> MODIFIED_AT = createField(DSL.name("modified_at"), SQLDataType.LOCALDATETIME(6), this, "");

    private CartItems(Name alias, Table<CartItemsRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private CartItems(Name alias, Table<CartItemsRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.cart_items</code> table reference
     */
    public CartItems(String alias) {
        this(DSL.name(alias), CART_ITEMS);
    }

    /**
     * Create an aliased <code>public.cart_items</code> table reference
     */
    public CartItems(Name alias) {
        this(alias, CART_ITEMS);
    }

    /**
     * Create a <code>public.cart_items</code> table reference
     */
    public CartItems() {
        this(DSL.name("cart_items"), null);
    }

    public <O extends Record> CartItems(Table<O> path, ForeignKey<O, CartItemsRecord> childPath, InverseForeignKey<O, CartItemsRecord> parentPath) {
        super(path, childPath, parentPath, CART_ITEMS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class CartItemsPath extends CartItems implements Path<CartItemsRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> CartItemsPath(Table<O> path, ForeignKey<O, CartItemsRecord> childPath, InverseForeignKey<O, CartItemsRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private CartItemsPath(Name alias, Table<CartItemsRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public CartItemsPath as(String alias) {
            return new CartItemsPath(DSL.name(alias), this);
        }

        @Override
        public CartItemsPath as(Name alias) {
            return new CartItemsPath(alias, this);
        }

        @Override
        public CartItemsPath as(Table<?> alias) {
            return new CartItemsPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CartItemsRecord, Long> getIdentity() {
        return (Identity<CartItemsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CartItemsRecord> getPrimaryKey() {
        return Keys.CART_ITEMS_PKEY;
    }

    @Override
    public List<ForeignKey<CartItemsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CART_ITEMS__CART_ITEMS_CART_ID_FKEY, Keys.CART_ITEMS__CART_ITEMS_PRODUCT_ID_FKEY);
    }

    private transient CartsPath _carts;

    /**
     * Get the implicit join path to the <code>public.carts</code> table.
     */
    public CartsPath carts() {
        if (_carts == null)
            _carts = new CartsPath(this, Keys.CART_ITEMS__CART_ITEMS_CART_ID_FKEY, null);

        return _carts;
    }

    private transient ProductsPath _products;

    /**
     * Get the implicit join path to the <code>public.products</code> table.
     */
    public ProductsPath products() {
        if (_products == null)
            _products = new ProductsPath(this, Keys.CART_ITEMS__CART_ITEMS_PRODUCT_ID_FKEY, null);

        return _products;
    }

    @Override
    public CartItems as(String alias) {
        return new CartItems(DSL.name(alias), this);
    }

    @Override
    public CartItems as(Name alias) {
        return new CartItems(alias, this);
    }

    @Override
    public CartItems as(Table<?> alias) {
        return new CartItems(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public CartItems rename(String name) {
        return new CartItems(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CartItems rename(Name name) {
        return new CartItems(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public CartItems rename(Table<?> name) {
        return new CartItems(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CartItems where(Condition condition) {
        return new CartItems(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CartItems where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CartItems where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CartItems where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public CartItems where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public CartItems where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public CartItems where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public CartItems where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CartItems whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public CartItems whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
