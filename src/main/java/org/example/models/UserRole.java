package org.example.models;

import java.util.Map;

public class UserRole {

    public static final String HR = "hr";

    public static final String MANAGEMENT = "management";

    int roleId;

    public static final Map<Integer, String> rolesMap = Map.of(
            1, HR,
            2, MANAGEMENT
    );

    public UserRole(int roleId) { setRoleId(roleId); }

    public String getRoleName() {return rolesMap.get(getRoleId());}


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
