package com.nitish.self.teacherstudentmanagement.utils;

import com.nitish.self.teacherstudentmanagement.model.RoleName;

public class RoleUtil {

    public static boolean checkRole(String role) {
        for (RoleName roleName : RoleName.values()) {
            if (roleName.name().equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }
}
