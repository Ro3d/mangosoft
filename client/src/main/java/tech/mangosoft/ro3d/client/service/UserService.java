package tech.mangosoft.ro3d.client.service;

import tech.mangosoft.ro3d.client.entity.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);

}
