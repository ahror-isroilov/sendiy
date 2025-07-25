/*
 * This file is generated by jOOQ.
 */
package com.sendiy.common.jooq.tables.records;


import com.sendiy.common.jooq.tables.RolePermissions;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RolePermissionsRecord extends TableRecordImpl<RolePermissionsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.role_permissions.role_id</code>.
     */
    public void setRoleId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.role_permissions.role_id</code>.
     */
    public Long getRoleId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.role_permissions.permission</code>.
     */
    public void setPermission(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.role_permissions.permission</code>.
     */
    public String getPermission() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RolePermissionsRecord
     */
    public RolePermissionsRecord() {
        super(RolePermissions.ROLE_PERMISSIONS);
    }

    /**
     * Create a detached, initialised RolePermissionsRecord
     */
    public RolePermissionsRecord(Long roleId, String permission) {
        super(RolePermissions.ROLE_PERMISSIONS);

        setRoleId(roleId);
        setPermission(permission);
        resetChangedOnNotNull();
    }
}
