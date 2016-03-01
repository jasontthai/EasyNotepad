/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.beans.Note;

/**
 * @author trit
 *
 */
public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findByNotepadId(String notepadId);
}
