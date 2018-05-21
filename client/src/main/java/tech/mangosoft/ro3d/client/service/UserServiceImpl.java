package tech.mangosoft.ro3d.client.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tech.mangosoft.ro3d.client.entity.Role;
import tech.mangosoft.ro3d.client.entity.User;
import tech.mangosoft.ro3d.client.repository.RoleRepository;
import tech.mangosoft.ro3d.client.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        Set<Role> role = new HashSet<>();
        Role userRole = roleRepository.findByRole("USER");
        if (userRole != null) {
            role.add(userRole);
        }
        user.setRoles(role);
        user.setActive(1);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
