package ru.practicum.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody @Valid User user) {
        log.info("Создан пользователь ={}", user.getName());
        return userService.createUser(user);
    }

    @PatchMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        //Нужна ли здесь валидация? Просто тесты передают экземпляр user с email = null, а по условиям одного из тестов
        //мы не можем создать экземпляр user с пустым email
        User modifiedUser = userService.updateUser(id, user);
        log.info("Пользовател c id ={} обвновлён в базе данных", id);
        return modifiedUser;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
        log.info("Пользовател c id ={} удалён из базы данных", id);
    }

}