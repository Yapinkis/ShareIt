package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User createUser(User user) {
        return repository.createUser(user);
    }

    @Override
    public User getUser(Long id) {
        return repository.getUser(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        return repository.updateUser(id, user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteUser(id);
    }


}