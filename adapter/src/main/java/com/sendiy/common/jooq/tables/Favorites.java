/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq.tables;


import com.sendiy.common.jooq.Keys;
import com.sendiy.common.jooq.Public;
import com.sendiy.common.jooq.tables.Products.ProductsPath;
import com.sendiy.common.jooq.tables.Users.UsersPath;
import com.sendiy.common.jooq.tables.records.FavoritesRecord;

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
public class Favorites extends TableImpl<FavoritesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.favorites</code>
     */
    public static final Favorites FAVORITES = new Favorites();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FavoritesRecord> getRecordType() {
        return FavoritesRecord.class;
    }

    /**
     * The column <code>public.favorites.id</code>.
     */
    public final TableField<FavoritesRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.favorites.user_id</code>.
     */
    public final TableField<FavoritesRecord, UUID> USER_ID = createField(DSL.name("user_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.favorites.product_id</code>.
     */
    public final TableField<FavoritesRecord, UUID> PRODUCT_ID = createField(DSL.name("product_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.favorites.added_at</code>.
     */
    public final TableField<FavoritesRecord, LocalDateTime> ADDED_AT = createField(DSL.name("added_at"), SQLDataType.LOCALDATETIME(6), this, "");

    private Favorites(Name alias, Table<FavoritesRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Favorites(Name alias, Table<FavoritesRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.favorites</code> table reference
     */
    public Favorites(String alias) {
        this(DSL.name(alias), FAVORITES);
    }

    /**
     * Create an aliased <code>public.favorites</code> table reference
     */
    public Favorites(Name alias) {
        this(alias, FAVORITES);
    }

    /**
     * Create a <code>public.favorites</code> table reference
     */
    public Favorites() {
        this(DSL.name("favorites"), null);
    }

    public <O extends Record> Favorites(Table<O> path, ForeignKey<O, FavoritesRecord> childPath, InverseForeignKey<O, FavoritesRecord> parentPath) {
        super(path, childPath, parentPath, FAVORITES);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class FavoritesPath extends Favorites implements Path<FavoritesRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> FavoritesPath(Table<O> path, ForeignKey<O, FavoritesRecord> childPath, InverseForeignKey<O, FavoritesRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private FavoritesPath(Name alias, Table<FavoritesRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public FavoritesPath as(String alias) {
            return new FavoritesPath(DSL.name(alias), this);
        }

        @Override
        public FavoritesPath as(Name alias) {
            return new FavoritesPath(alias, this);
        }

        @Override
        public FavoritesPath as(Table<?> alias) {
            return new FavoritesPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<FavoritesRecord, Long> getIdentity() {
        return (Identity<FavoritesRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<FavoritesRecord> getPrimaryKey() {
        return Keys.FAVORITES_PKEY;
    }

    @Override
    public List<ForeignKey<FavoritesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FAVORITES__FAVORITES_USER_ID_FKEY, Keys.FAVORITES__FAVORITES_PRODUCT_ID_FKEY);
    }

    private transient UsersPath _users;

    /**
     * Get the implicit join path to the <code>public.users</code> table.
     */
    public UsersPath users() {
        if (_users == null)
            _users = new UsersPath(this, Keys.FAVORITES__FAVORITES_USER_ID_FKEY, null);

        return _users;
    }

    private transient ProductsPath _products;

    /**
     * Get the implicit join path to the <code>public.products</code> table.
     */
    public ProductsPath products() {
        if (_products == null)
            _products = new ProductsPath(this, Keys.FAVORITES__FAVORITES_PRODUCT_ID_FKEY, null);

        return _products;
    }

    @Override
    public Favorites as(String alias) {
        return new Favorites(DSL.name(alias), this);
    }

    @Override
    public Favorites as(Name alias) {
        return new Favorites(alias, this);
    }

    @Override
    public Favorites as(Table<?> alias) {
        return new Favorites(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Favorites rename(String name) {
        return new Favorites(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Favorites rename(Name name) {
        return new Favorites(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Favorites rename(Table<?> name) {
        return new Favorites(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Favorites where(Condition condition) {
        return new Favorites(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Favorites where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Favorites where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Favorites where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Favorites where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Favorites where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Favorites where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Favorites where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Favorites whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Favorites whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
