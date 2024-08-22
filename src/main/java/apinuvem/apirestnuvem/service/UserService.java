package apinuvem.apirestnuvem.service;

import apinuvem.apirestnuvem.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
