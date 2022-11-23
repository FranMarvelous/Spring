package cl.generation.services;

import java.util.Optional;

import cl.generation.models.User;

public interface UserService  {

    public Optional<User> getUserById(Long id);

}
