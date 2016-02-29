/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.beans.Notepad;

/**
 * @author trit
 *
 */
public interface NotepadRepository extends MongoRepository<Notepad, String> {

}
