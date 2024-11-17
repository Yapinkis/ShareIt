package ru.practicum.user;

import java.util.List;

interface UserService {
    User createUser(User user);
    User getUser(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}