package pe.isil.empresa.service;

import pe.isil.empresa.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
