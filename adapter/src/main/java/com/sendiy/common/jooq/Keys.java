/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq;


import com.sendiy.common.jooq.tables.CartItems;
import com.sendiy.common.jooq.tables.Carts;
import com.sendiy.common.jooq.tables.Categories;
import com.sendiy.common.jooq.tables.Favorites;
import com.sendiy.common.jooq.tables.Files;
import com.sendiy.common.jooq.tables.FlywaySchemaHistory;
import com.sendiy.common.jooq.tables.OrderItems;
import com.sendiy.common.jooq.tables.Orders;
import com.sendiy.common.jooq.tables.ProductImages;
import com.sendiy.common.jooq.tables.Products;
import com.sendiy.common.jooq.tables.RefreshTokens;
import com.sendiy.common.jooq.tables.Reviews;
import com.sendiy.common.jooq.tables.RolePermissions;
import com.sendiy.common.jooq.tables.Roles;
import com.sendiy.common.jooq.tables.ShippingAddress;
import com.sendiy.common.jooq.tables.Shops;
import com.sendiy.common.jooq.tables.Transactions;
import com.sendiy.common.jooq.tables.Users;
import com.sendiy.common.jooq.tables.records.CartItemsRecord;
import com.sendiy.common.jooq.tables.records.CartsRecord;
import com.sendiy.common.jooq.tables.records.CategoriesRecord;
import com.sendiy.common.jooq.tables.records.FavoritesRecord;
import com.sendiy.common.jooq.tables.records.FilesRecord;
import com.sendiy.common.jooq.tables.records.FlywaySchemaHistoryRecord;
import com.sendiy.common.jooq.tables.records.OrderItemsRecord;
import com.sendiy.common.jooq.tables.records.OrdersRecord;
import com.sendiy.common.jooq.tables.records.ProductImagesRecord;
import com.sendiy.common.jooq.tables.records.ProductsRecord;
import com.sendiy.common.jooq.tables.records.RefreshTokensRecord;
import com.sendiy.common.jooq.tables.records.ReviewsRecord;
import com.sendiy.common.jooq.tables.records.RolePermissionsRecord;
import com.sendiy.common.jooq.tables.records.RolesRecord;
import com.sendiy.common.jooq.tables.records.ShippingAddressRecord;
import com.sendiy.common.jooq.tables.records.ShopsRecord;
import com.sendiy.common.jooq.tables.records.TransactionsRecord;
import com.sendiy.common.jooq.tables.records.UsersRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CartItemsRecord> CART_ITEMS_PKEY = Internal.createUniqueKey(CartItems.CART_ITEMS, DSL.name("cart_items_pkey"), new TableField[] { CartItems.CART_ITEMS.ID }, true);
    public static final UniqueKey<CartsRecord> CARTS_PKEY = Internal.createUniqueKey(Carts.CARTS, DSL.name("carts_pkey"), new TableField[] { Carts.CARTS.ID }, true);
    public static final UniqueKey<CategoriesRecord> CATEGORIES_PKEY = Internal.createUniqueKey(Categories.CATEGORIES, DSL.name("categories_pkey"), new TableField[] { Categories.CATEGORIES.ID }, true);
    public static final UniqueKey<FavoritesRecord> FAVORITES_PKEY = Internal.createUniqueKey(Favorites.FAVORITES, DSL.name("favorites_pkey"), new TableField[] { Favorites.FAVORITES.ID }, true);
    public static final UniqueKey<FilesRecord> FILES_PKEY = Internal.createUniqueKey(Files.FILES, DSL.name("files_pkey"), new TableField[] { Files.FILES.ID }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<OrderItemsRecord> ORDER_ITEMS_PKEY = Internal.createUniqueKey(OrderItems.ORDER_ITEMS, DSL.name("order_items_pkey"), new TableField[] { OrderItems.ORDER_ITEMS.ID }, true);
    public static final UniqueKey<OrdersRecord> ORDERS_PKEY = Internal.createUniqueKey(Orders.ORDERS, DSL.name("orders_pkey"), new TableField[] { Orders.ORDERS.ID }, true);
    public static final UniqueKey<ProductImagesRecord> PRODUCT_IMAGES_PKEY = Internal.createUniqueKey(ProductImages.PRODUCT_IMAGES, DSL.name("product_images_pkey"), new TableField[] { ProductImages.PRODUCT_IMAGES.ID }, true);
    public static final UniqueKey<ProductsRecord> PRODUCTS_PKEY = Internal.createUniqueKey(Products.PRODUCTS, DSL.name("products_pkey"), new TableField[] { Products.PRODUCTS.ID }, true);
    public static final UniqueKey<RefreshTokensRecord> REFRESH_TOKENS_PKEY = Internal.createUniqueKey(RefreshTokens.REFRESH_TOKENS, DSL.name("refresh_tokens_pkey"), new TableField[] { RefreshTokens.REFRESH_TOKENS.ID }, true);
    public static final UniqueKey<ReviewsRecord> REVIEWS_PKEY = Internal.createUniqueKey(Reviews.REVIEWS, DSL.name("reviews_pkey"), new TableField[] { Reviews.REVIEWS.ID }, true);
    public static final UniqueKey<RolesRecord> ROLES_PKEY = Internal.createUniqueKey(Roles.ROLES, DSL.name("roles_pkey"), new TableField[] { Roles.ROLES.ID }, true);
    public static final UniqueKey<ShippingAddressRecord> SHIPPING_ADDRESS_PKEY = Internal.createUniqueKey(ShippingAddress.SHIPPING_ADDRESS, DSL.name("shipping_address_pkey"), new TableField[] { ShippingAddress.SHIPPING_ADDRESS.ID }, true);
    public static final UniqueKey<ShopsRecord> SHOPS_PKEY = Internal.createUniqueKey(Shops.SHOPS, DSL.name("shops_pkey"), new TableField[] { Shops.SHOPS.ID }, true);
    public static final UniqueKey<TransactionsRecord> TRANSACTIONS_PKEY = Internal.createUniqueKey(Transactions.TRANSACTIONS, DSL.name("transactions_pkey"), new TableField[] { Transactions.TRANSACTIONS.ID }, true);
    public static final UniqueKey<UsersRecord> USERS_PKEY = Internal.createUniqueKey(Users.USERS, DSL.name("users_pkey"), new TableField[] { Users.USERS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CartItemsRecord, CartsRecord> CART_ITEMS__CART_ITEMS_CART_ID_FKEY = Internal.createForeignKey(CartItems.CART_ITEMS, DSL.name("cart_items_cart_id_fkey"), new TableField[] { CartItems.CART_ITEMS.CART_ID }, Keys.CARTS_PKEY, new TableField[] { Carts.CARTS.ID }, true);
    public static final ForeignKey<CartItemsRecord, ProductsRecord> CART_ITEMS__CART_ITEMS_PRODUCT_ID_FKEY = Internal.createForeignKey(CartItems.CART_ITEMS, DSL.name("cart_items_product_id_fkey"), new TableField[] { CartItems.CART_ITEMS.PRODUCT_ID }, Keys.PRODUCTS_PKEY, new TableField[] { Products.PRODUCTS.ID }, true);
    public static final ForeignKey<CartsRecord, UsersRecord> CARTS__CARTS_CREATED_BY_FKEY = Internal.createForeignKey(Carts.CARTS, DSL.name("carts_created_by_fkey"), new TableField[] { Carts.CARTS.CREATED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<CartsRecord, UsersRecord> CARTS__CARTS_USER_ID_FKEY = Internal.createForeignKey(Carts.CARTS, DSL.name("carts_user_id_fkey"), new TableField[] { Carts.CARTS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<CategoriesRecord, FilesRecord> CATEGORIES__CATEGORIES_IMAGE_ID_FKEY = Internal.createForeignKey(Categories.CATEGORIES, DSL.name("categories_image_id_fkey"), new TableField[] { Categories.CATEGORIES.IMAGE_ID }, Keys.FILES_PKEY, new TableField[] { Files.FILES.ID }, true);
    public static final ForeignKey<CategoriesRecord, CategoriesRecord> CATEGORIES__CATEGORIES_PARENT_ID_FKEY = Internal.createForeignKey(Categories.CATEGORIES, DSL.name("categories_parent_id_fkey"), new TableField[] { Categories.CATEGORIES.PARENT_ID }, Keys.CATEGORIES_PKEY, new TableField[] { Categories.CATEGORIES.ID }, true);
    public static final ForeignKey<FavoritesRecord, ProductsRecord> FAVORITES__FAVORITES_PRODUCT_ID_FKEY = Internal.createForeignKey(Favorites.FAVORITES, DSL.name("favorites_product_id_fkey"), new TableField[] { Favorites.FAVORITES.PRODUCT_ID }, Keys.PRODUCTS_PKEY, new TableField[] { Products.PRODUCTS.ID }, true);
    public static final ForeignKey<FavoritesRecord, UsersRecord> FAVORITES__FAVORITES_USER_ID_FKEY = Internal.createForeignKey(Favorites.FAVORITES, DSL.name("favorites_user_id_fkey"), new TableField[] { Favorites.FAVORITES.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<OrderItemsRecord, OrdersRecord> ORDER_ITEMS__ORDER_ITEMS_ORDER_ID_FKEY = Internal.createForeignKey(OrderItems.ORDER_ITEMS, DSL.name("order_items_order_id_fkey"), new TableField[] { OrderItems.ORDER_ITEMS.ORDER_ID }, Keys.ORDERS_PKEY, new TableField[] { Orders.ORDERS.ID }, true);
    public static final ForeignKey<OrderItemsRecord, ProductsRecord> ORDER_ITEMS__ORDER_ITEMS_PRODUCT_ID_FKEY = Internal.createForeignKey(OrderItems.ORDER_ITEMS, DSL.name("order_items_product_id_fkey"), new TableField[] { OrderItems.ORDER_ITEMS.PRODUCT_ID }, Keys.PRODUCTS_PKEY, new TableField[] { Products.PRODUCTS.ID }, true);
    public static final ForeignKey<OrdersRecord, CartsRecord> ORDERS__ORDERS_CART_ID_FKEY = Internal.createForeignKey(Orders.ORDERS, DSL.name("orders_cart_id_fkey"), new TableField[] { Orders.ORDERS.CART_ID }, Keys.CARTS_PKEY, new TableField[] { Carts.CARTS.ID }, true);
    public static final ForeignKey<OrdersRecord, UsersRecord> ORDERS__ORDERS_CREATED_BY_FKEY = Internal.createForeignKey(Orders.ORDERS, DSL.name("orders_created_by_fkey"), new TableField[] { Orders.ORDERS.CREATED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<OrdersRecord, UsersRecord> ORDERS__ORDERS_USER_ID_FKEY = Internal.createForeignKey(Orders.ORDERS, DSL.name("orders_user_id_fkey"), new TableField[] { Orders.ORDERS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ProductImagesRecord, FilesRecord> PRODUCT_IMAGES__PRODUCT_IMAGES_FILE_ID_FKEY = Internal.createForeignKey(ProductImages.PRODUCT_IMAGES, DSL.name("product_images_file_id_fkey"), new TableField[] { ProductImages.PRODUCT_IMAGES.FILE_ID }, Keys.FILES_PKEY, new TableField[] { Files.FILES.ID }, true);
    public static final ForeignKey<ProductImagesRecord, ProductImagesRecord> PRODUCT_IMAGES__PRODUCT_IMAGES_MEDIUM_ID_FKEY = Internal.createForeignKey(ProductImages.PRODUCT_IMAGES, DSL.name("product_images_medium_id_fkey"), new TableField[] { ProductImages.PRODUCT_IMAGES.MEDIUM_ID }, Keys.PRODUCT_IMAGES_PKEY, new TableField[] { ProductImages.PRODUCT_IMAGES.ID }, true);
    public static final ForeignKey<ProductImagesRecord, ProductsRecord> PRODUCT_IMAGES__PRODUCT_IMAGES_PRODUCT_ID_FKEY = Internal.createForeignKey(ProductImages.PRODUCT_IMAGES, DSL.name("product_images_product_id_fkey"), new TableField[] { ProductImages.PRODUCT_IMAGES.PRODUCT_ID }, Keys.PRODUCTS_PKEY, new TableField[] { Products.PRODUCTS.ID }, true);
    public static final ForeignKey<ProductImagesRecord, ProductImagesRecord> PRODUCT_IMAGES__PRODUCT_IMAGES_SMALL_ID_FKEY = Internal.createForeignKey(ProductImages.PRODUCT_IMAGES, DSL.name("product_images_small_id_fkey"), new TableField[] { ProductImages.PRODUCT_IMAGES.SMALL_ID }, Keys.PRODUCT_IMAGES_PKEY, new TableField[] { ProductImages.PRODUCT_IMAGES.ID }, true);
    public static final ForeignKey<ProductsRecord, CategoriesRecord> PRODUCTS__PRODUCTS_CATEGORY_ID_FKEY = Internal.createForeignKey(Products.PRODUCTS, DSL.name("products_category_id_fkey"), new TableField[] { Products.PRODUCTS.CATEGORY_ID }, Keys.CATEGORIES_PKEY, new TableField[] { Categories.CATEGORIES.ID }, true);
    public static final ForeignKey<ProductsRecord, UsersRecord> PRODUCTS__PRODUCTS_CREATED_BY_FKEY = Internal.createForeignKey(Products.PRODUCTS, DSL.name("products_created_by_fkey"), new TableField[] { Products.PRODUCTS.CREATED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ProductsRecord, UsersRecord> PRODUCTS__PRODUCTS_MODIFIED_BY_FKEY = Internal.createForeignKey(Products.PRODUCTS, DSL.name("products_modified_by_fkey"), new TableField[] { Products.PRODUCTS.MODIFIED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ProductsRecord, ShopsRecord> PRODUCTS__PRODUCTS_SHOP_ID_FKEY = Internal.createForeignKey(Products.PRODUCTS, DSL.name("products_shop_id_fkey"), new TableField[] { Products.PRODUCTS.SHOP_ID }, Keys.SHOPS_PKEY, new TableField[] { Shops.SHOPS.ID }, true);
    public static final ForeignKey<ProductsRecord, UsersRecord> PRODUCTS__PRODUCTS_USER_ID_FKEY = Internal.createForeignKey(Products.PRODUCTS, DSL.name("products_user_id_fkey"), new TableField[] { Products.PRODUCTS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<RefreshTokensRecord, UsersRecord> REFRESH_TOKENS__REFRESH_TOKENS_USER_ID_FKEY = Internal.createForeignKey(RefreshTokens.REFRESH_TOKENS, DSL.name("refresh_tokens_user_id_fkey"), new TableField[] { RefreshTokens.REFRESH_TOKENS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ReviewsRecord, UsersRecord> REVIEWS__REVIEWS_CREATED_BY_FKEY = Internal.createForeignKey(Reviews.REVIEWS, DSL.name("reviews_created_by_fkey"), new TableField[] { Reviews.REVIEWS.CREATED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ReviewsRecord, ProductsRecord> REVIEWS__REVIEWS_PRODUCT_ID_FKEY = Internal.createForeignKey(Reviews.REVIEWS, DSL.name("reviews_product_id_fkey"), new TableField[] { Reviews.REVIEWS.PRODUCT_ID }, Keys.PRODUCTS_PKEY, new TableField[] { Products.PRODUCTS.ID }, true);
    public static final ForeignKey<ReviewsRecord, UsersRecord> REVIEWS__REVIEWS_USER_ID_FKEY = Internal.createForeignKey(Reviews.REVIEWS, DSL.name("reviews_user_id_fkey"), new TableField[] { Reviews.REVIEWS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<RolePermissionsRecord, RolesRecord> ROLE_PERMISSIONS__ROLE_PERMISSIONS_ROLE_ID_FKEY = Internal.createForeignKey(RolePermissions.ROLE_PERMISSIONS, DSL.name("role_permissions_role_id_fkey"), new TableField[] { RolePermissions.ROLE_PERMISSIONS.ROLE_ID }, Keys.ROLES_PKEY, new TableField[] { Roles.ROLES.ID }, true);
    public static final ForeignKey<ShippingAddressRecord, UsersRecord> SHIPPING_ADDRESS__SHIPPING_ADDRESS_USER_ID_FKEY = Internal.createForeignKey(ShippingAddress.SHIPPING_ADDRESS, DSL.name("shipping_address_user_id_fkey"), new TableField[] { ShippingAddress.SHIPPING_ADDRESS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ShopsRecord, UsersRecord> SHOPS__SHOPS_CREATED_BY_FKEY = Internal.createForeignKey(Shops.SHOPS, DSL.name("shops_created_by_fkey"), new TableField[] { Shops.SHOPS.CREATED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ShopsRecord, UsersRecord> SHOPS__SHOPS_MODIFIED_BY_FKEY = Internal.createForeignKey(Shops.SHOPS, DSL.name("shops_modified_by_fkey"), new TableField[] { Shops.SHOPS.MODIFIED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<ShopsRecord, UsersRecord> SHOPS__SHOPS_USER_ID_FKEY = Internal.createForeignKey(Shops.SHOPS, DSL.name("shops_user_id_fkey"), new TableField[] { Shops.SHOPS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<TransactionsRecord, OrdersRecord> TRANSACTIONS__TRANSACTIONS_ORDER_ID_FKEY = Internal.createForeignKey(Transactions.TRANSACTIONS, DSL.name("transactions_order_id_fkey"), new TableField[] { Transactions.TRANSACTIONS.ORDER_ID }, Keys.ORDERS_PKEY, new TableField[] { Orders.ORDERS.ID }, true);
    public static final ForeignKey<UsersRecord, FilesRecord> USERS__USERS_AVATAR_ID_FKEY = Internal.createForeignKey(Users.USERS, DSL.name("users_avatar_id_fkey"), new TableField[] { Users.USERS.AVATAR_ID }, Keys.FILES_PKEY, new TableField[] { Files.FILES.ID }, true);
    public static final ForeignKey<UsersRecord, UsersRecord> USERS__USERS_CREATED_BY_FKEY = Internal.createForeignKey(Users.USERS, DSL.name("users_created_by_fkey"), new TableField[] { Users.USERS.CREATED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<UsersRecord, UsersRecord> USERS__USERS_MODIFIED_BY_FKEY = Internal.createForeignKey(Users.USERS, DSL.name("users_modified_by_fkey"), new TableField[] { Users.USERS.MODIFIED_BY }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<UsersRecord, RolesRecord> USERS__USERS_ROLE_ID_FKEY = Internal.createForeignKey(Users.USERS, DSL.name("users_role_id_fkey"), new TableField[] { Users.USERS.ROLE_ID }, Keys.ROLES_PKEY, new TableField[] { Roles.ROLES.ID }, true);
}
