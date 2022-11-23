package cl.generation.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.generation.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);
}

