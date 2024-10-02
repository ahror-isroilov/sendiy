CREATE TYPE "file_type" AS ENUM (
  'IMAGE',
  'DOCUMENT',
  'AUDIO',
  'VIDEO'
);

CREATE TYPE "user_status" AS ENUM (
  'ACTIVE',
  'BLOCKED',
  'DISABLED'
);

CREATE TYPE "payment_status" AS ENUM (
  'SUCCESS',
  'FAILED',
  'PENDING'
);

CREATE TYPE "shop_status" AS ENUM (
  'ACTIVE',
  'DISABLED'
);

CREATE TYPE "order_status" AS ENUM (
  'PENDING',
  'PROCESSING',
  'SHIPPED',
  'DELIVERED',
  'CANCELED'
);

CREATE TABLE "users"
(
    "id"            uuid PRIMARY KEY,
    "firstname"     varchar(32),
    "lastname"      varchar(32),
    "phone"         varchar(12),
    "password_hash" varchar(255),
    "role_id"       int NOT NULL,
    "avatar_id"     uuid,
    "bio"           text,
    "status"        user_status,
    "created_at"    timestamp,
    "created_by"    uuid,
    "modified_at"   timestamp,
    "modified_by"   uuid,
    "deleted_date"  timestamp DEFAULT null
);

CREATE TABLE "roles"
(
    "id"   bigserial PRIMARY KEY,
    "name" varchar(32)
);

CREATE TABLE "role_permissions"
(
    "role_id"    int,
    "permission" varchar(128)
);

CREATE TABLE "files"
(
    "id"   uuid PRIMARY KEY,
    "name" varchar(64),
    "type" file_type,
    "path" varchar NOT NULL
);

CREATE TABLE "categories"
(
    "id"          bigserial PRIMARY KEY,
    "name"        varchar(32) NOT NULL,
    "description" text,
    "parent_id"   int,
    "image_id"    uuid
);

CREATE TABLE "shops"
(
    "id"           uuid PRIMARY KEY,
    "name"         varchar(255) NOT NULL,
    "description"  text,
    "status"       shop_status DEFAULT 'ACTIVE',
    "user_id"      uuid         NOT NULL,
    "created_at"   timestamp,
    "created_by"   uuid,
    "modified_at"  timestamp,
    "modified_by"  uuid,
    "deleted_date" timestamp   DEFAULT null
);

CREATE TABLE "products"
(
    "id"           uuid PRIMARY KEY,
    "title"        varchar(100)   NOT NULL,
    "user_id"      uuid           NOT NULL,
    "description"  text,
    "price"        decimal(10, 2) NOT NULL,
    "quantity"     int4           NOT NULL,
    "shop_id"      uuid           NOT NULL,
    "category_id"  int,
    "created_at"   timestamp,
    "created_by"   uuid,
    "modified_at"  timestamp,
    "modified_by"  uuid,
    "deleted_date" timestamp DEFAULT null,
    "is_active"    bool      DEFAULT true
);

CREATE TABLE "product_images"
(
    "id"         bigserial PRIMARY KEY,
    "product_id" uuid NOT NULL,
    "file_id"    uuid NOT NULL,
    "is_primary" bool DEFAULT false
);

CREATE TABLE "carts"
(
    "id"         bigserial PRIMARY KEY,
    "user_id"    uuid NOT NULL,
    "created_at" timestamp,
    "created_by" uuid
);

CREATE TABLE "cart_items"
(
    "id"          bigserial PRIMARY KEY,
    "cart_id"     int            NOT NULL,
    "product_id"  uuid           NOT NULL,
    "quantity"    int            NOT NULL,
    "price"       decimal(10, 2) NOT NULL,
    "added_at"    timestamp,
    "modified_at" timestamp
);

CREATE TABLE "orders"
(
    "id"               uuid PRIMARY KEY,
    "user_id"          uuid           NOT NULL,
    "cart_id"          bigint         NOT NULL,
    "status"           order_status,
    "total"            decimal(10, 2) NOT NULL,
    "shipping_address" text,
    "created_at"       timestamp,
    "created_by"       uuid,
    "modified_at"      timestamp
);

CREATE TABLE "order_items"
(
    "id"         uuid PRIMARY KEY,
    "order_id"   uuid           NOT NULL,
    "product_id" uuid           NOT NULL,
    "quantity"   int            NOT NULL,
    "price"      decimal(10, 2) NOT NULL,
    "added_at"   timestamp
);

CREATE TABLE "reviews"
(
    "id"         bigserial PRIMARY KEY,
    "product_id" uuid,
    "user_id"    uuid,
    "rating"     int2,
    "comment"    text,
    "created_at" timestamp,
    "created_by" uuid
);

CREATE TABLE "shipping_address"
(
    "id"             bigserial PRIMARY KEY,
    "user_id"        uuid,
    "recipient_name" varchar(255),
    "region"         varchar(255),
    "district"       varchar(255),
    "city"           varchar(255),
    "street"         varchar(255),
    "home_number"    int
);

CREATE TABLE "favorites"
(
    "id"         bigserial PRIMARY KEY,
    "user_id"    uuid NOT NULL,
    "product_id" uuid NOT NULL,
    "added_at"   timestamp
);

CREATE TABLE "transactions"
(
    "id"             uuid PRIMARY KEY,
    "order_id"       uuid           NOT NULL,
    "payment_method" varchar(55)    NOT NULL,
    "status"         payment_status NOT NULL,
    "created_at"     timestamp
);

COMMENT
ON TABLE "users" IS 'this is general user table';

ALTER TABLE "users"
    ADD FOREIGN KEY ("role_id") REFERENCES "roles" ("id");

ALTER TABLE "users"
    ADD FOREIGN KEY ("avatar_id") REFERENCES "files" ("id");

ALTER TABLE "users"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "users"
    ADD FOREIGN KEY ("modified_by") REFERENCES "users" ("id");

ALTER TABLE "role_permissions"
    ADD FOREIGN KEY ("role_id") REFERENCES "roles" ("id");

ALTER TABLE "categories"
    ADD FOREIGN KEY ("parent_id") REFERENCES "categories" ("id");

ALTER TABLE "categories"
    ADD FOREIGN KEY ("image_id") REFERENCES "files" ("id");

ALTER TABLE "shops"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "shops"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "shops"
    ADD FOREIGN KEY ("modified_by") REFERENCES "users" ("id");

ALTER TABLE "products"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "products"
    ADD FOREIGN KEY ("shop_id") REFERENCES "shops" ("id");

ALTER TABLE "products"
    ADD FOREIGN KEY ("category_id") REFERENCES "categories" ("id");

ALTER TABLE "products"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "products"
    ADD FOREIGN KEY ("modified_by") REFERENCES "users" ("id");

ALTER TABLE "product_images"
    ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id");

ALTER TABLE "product_images"
    ADD FOREIGN KEY ("file_id") REFERENCES "files" ("id");

ALTER TABLE "carts"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "carts"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "cart_items"
    ADD FOREIGN KEY ("cart_id") REFERENCES "carts" ("id");

ALTER TABLE "cart_items"
    ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id");

ALTER TABLE "orders"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "orders"
    ADD FOREIGN KEY ("cart_id") REFERENCES "carts" ("id");

ALTER TABLE "orders"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "order_items"
    ADD FOREIGN KEY ("order_id") REFERENCES "orders" ("id");

ALTER TABLE "order_items"
    ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id");

ALTER TABLE "reviews"
    ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id");

ALTER TABLE "reviews"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "reviews"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "shipping_address"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "favorites"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "favorites"
    ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id");

ALTER TABLE "transactions"
    ADD FOREIGN KEY ("order_id") REFERENCES "orders" ("id");