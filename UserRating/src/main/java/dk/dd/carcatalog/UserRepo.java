package dk.dd.carcatalog;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface UserRepo extends MongoRepository<User, String>
{
    User findByName(String name);
}