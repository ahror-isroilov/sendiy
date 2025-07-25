/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq.tables;


import com.sendiy.common.jooq.Keys;
import com.sendiy.common.jooq.Public;
import com.sendiy.common.jooq.tables.Categories.CategoriesPath;
import com.sendiy.common.jooq.tables.Files.FilesPath;
import com.sendiy.common.jooq.tables.Products.ProductsPath;
import com.sendiy.common.jooq.tables.records.CategoriesRecord;

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
public class Categories extends TableImpl<CategoriesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.categories</code>
     */
    public static final Categories CATEGORIES = new Categories();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CategoriesRecord> getRecordType() {
        return CategoriesRecord.class;
    }

    /**
     * The column <code>public.categories.id</code>.
     */
    public final TableField<CategoriesRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.categories.name</code>.
     */
    public final TableField<CategoriesRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>public.categories.description</code>.
     */
    public final TableField<CategoriesRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.categories.parent_id</code>.
     */
    public final TableField<CategoriesRecord, Integer> PARENT_ID = createField(DSL.name("parent_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.categories.image_id</code>.
     */
    public final TableField<CategoriesRecord, UUID> IMAGE_ID = createField(DSL.name("image_id"), SQLDataType.UUID, this, "");

    private Categories(Name alias, Table<CategoriesRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Categories(Name alias, Table<CategoriesRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.categories</code> table reference
     */
    public Categories(String alias) {
        this(DSL.name(alias), CATEGORIES);
    }

    /**
     * Create an aliased <code>public.categories</code> table reference
     */
    public Categories(Name alias) {
        this(alias, CATEGORIES);
    }

    /**
     * Create a <code>public.categories</code> table reference
     */
    public Categories() {
        this(DSL.name("categories"), null);
    }

    public <O extends Record> Categories(Table<O> path, ForeignKey<O, CategoriesRecord> childPath, InverseForeignKey<O, CategoriesRecord> parentPath) {
        super(path, childPath, parentPath, CATEGORIES);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class CategoriesPath extends Categories implements Path<CategoriesRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> CategoriesPath(Table<O> path, ForeignKey<O, CategoriesRecord> childPath, InverseForeignKey<O, CategoriesRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private CategoriesPath(Name alias, Table<CategoriesRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public CategoriesPath as(String alias) {
            return new CategoriesPath(DSL.name(alias), this);
        }

        @Override
        public CategoriesPath as(Name alias) {
            return new CategoriesPath(alias, this);
        }

        @Override
        public CategoriesPath as(Table<?> alias) {
            return new CategoriesPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CategoriesRecord, Integer> getIdentity() {
        return (Identity<CategoriesRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<CategoriesRecord> getPrimaryKey() {
        return Keys.CATEGORIES_PKEY;
    }

    @Override
    public List<ForeignKey<CategoriesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CATEGORIES__CATEGORIES_PARENT_ID_FKEY, Keys.CATEGORIES__CATEGORIES_IMAGE_ID_FKEY);
    }

    private transient CategoriesPath _categories;

    /**
     * Get the implicit join path to the <code>public.categories</code> table.
     */
    public CategoriesPath categories() {
        if (_categories == null)
            _categories = new CategoriesPath(this, Keys.CATEGORIES__CATEGORIES_PARENT_ID_FKEY, null);

        return _categories;
    }

    private transient FilesPath _files;

    /**
     * Get the implicit join path to the <code>public.files</code> table.
     */
    public FilesPath files() {
        if (_files == null)
            _files = new FilesPath(this, Keys.CATEGORIES__CATEGORIES_IMAGE_ID_FKEY, null);

        return _files;
    }

    private transient ProductsPath _products;

    /**
     * Get the implicit to-many join path to the <code>public.products</code>
     * table
     */
    public ProductsPath products() {
        if (_products == null)
            _products = new ProductsPath(this, null, Keys.PRODUCTS__PRODUCTS_CATEGORY_ID_FKEY.getInverseKey());

        return _products;
    }

    @Override
    public Categories as(String alias) {
        return new Categories(DSL.name(alias), this);
    }

    @Override
    public Categories as(Name alias) {
        return new Categories(alias, this);
    }

    @Override
    public Categories as(Table<?> alias) {
        return new Categories(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Categories rename(String name) {
        return new Categories(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Categories rename(Name name) {
        return new Categories(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Categories rename(Table<?> name) {
        return new Categories(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Categories where(Condition condition) {
        return new Categories(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Categories where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Categories where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Categories where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Categories where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Categories where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Categories where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Categories where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Categories whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Categories whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
