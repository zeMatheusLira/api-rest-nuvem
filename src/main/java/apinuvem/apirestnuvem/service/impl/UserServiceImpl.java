package apinuvem.apirestnuvem.service.impl;

import apinuvem.apirestnuvem.domain.model.User;
import apinuvem.apirestnuvem.domain.repository.UserRepository;
import apinuvem.apirestnuvem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    // para criar o componente de serviço ele precisa injetar o UserRepository
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists!");
        }
        return userRepository.save(userToCreate);
    }
}
