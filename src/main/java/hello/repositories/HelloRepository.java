package hello.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.beans.Hello;

/**
 * Created by trit on 2/27/16.
 */
public interface HelloRepository extends MongoRepository<Hello, String> {

}
