package ru.practicum.user;

import jakarta.validation.ValidationException;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Data
public class UserRepositoryImpl implements UserRepository {
    private Long id = 0L;
    private Map <Long, User> users = new HashMap<>();

    @Override
    public User createUser(User user) {
        for (User checkUser : users.values()) {
            if (checkUser.getEmail().equals(user.getEmail())) {
                throw new ValidationException("Ошибка валидации, пользователь с данным email уже существует");
            }
        }
        User newUser = new User();
        newUser.setId(id);
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        users.put(id++,newUser);
        return newUser;
    }

    @Override
    public User getUser(Long id) {
        return users.get(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        User updatedUser = users.get(id);
        for (User checkUser : users.values()) {
            if (checkUser.getEmail().equals(user.getEmail())) {
                throw new ValidationException("Ошибка валидации, пользователь с данным email уже существует");
            }
        }
        if (user.getName() != null) {
            updatedUser.setName(user.getName());
        }
        if (user.getEmail() != null) {
            updatedUser.setEmail(user.getEmail());
        }
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        users.remove(id);
    }

    private static List<User> createManyFakeUsers(int count) {
        List<User> fakeUsers = new ArrayList<>();
        for (long id = 1; id <= count; id++) {
            fakeUsers.add(createFakeUser(id));
        }
        return Collections.unmodifiableList(fakeUsers);
    }

    private static User createFakeUser(long id) {
        User fakeUser = new User();
        fakeUser.setId(id);
        fakeUser.setEmail("mail" + id + "@example.com");
        fakeUser.setName("Akakiy Akakievich #" + id);
        return fakeUser;
    }

}