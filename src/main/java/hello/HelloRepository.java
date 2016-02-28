package hello;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by trit on 2/27/16.
 */
public interface HelloRepository extends MongoRepository<Hello, String> {

}
