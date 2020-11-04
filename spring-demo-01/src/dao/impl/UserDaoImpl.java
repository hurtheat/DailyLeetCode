package dao.impl;

import dao.UserDao;

/**
 * @author kyg
 * @version 1.0
 * @description
 * @since 2020/11/4 15:46
 */
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @Override
    public void getUser() {
        System.out.println("从数据库中查询数据...");
    }
}
