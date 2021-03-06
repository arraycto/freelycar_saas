package com.freelycar.saas.util;

import com.freelycar.saas.permission.entity.SysUser;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author tangwei [toby911115@gmail.com]
 * @date 2018/9/29
 */
public class BCryptPasswordEncoderGenerator {
    /**
     * 加密密码(BCrypt)
     */
    private static SysUser encryptPassword(SysUser sysUser) {
        String userName = sysUser.getUsername();
        String password = sysUser.getPassword();
        password = BCrypt.hashpw(password, userName);
        sysUser.setPassword(password);
        return sysUser;
    }

    public static void main(String[] args) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("sysadmin");
        sysUser.setPassword("sysadmin");
        System.out.println(encryptPassword(sysUser).getPassword());
    }
}
