package ru.practicum.user;

interface UserRepository {
    User createUser(User user);
    User getUser(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}