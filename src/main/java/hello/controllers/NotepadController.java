/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.beans.Note;
import hello.beans.Notepad;
import hello.repositories.NoteRepository;
import hello.repositories.NotepadRepository;

/**
 * @author trit
 *
 */
@RestController
public class NotepadController {

    @Autowired
    private NotepadRepository notepadRepository;

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(value = "/notepad")
    public List<Notepad> getNotePads() {
        return notepadRepository.findAll();
    }

    @RequestMapping(value = "/notepad", method = RequestMethod.POST)
    public Notepad createNotepad(@RequestBody @Valid final Notepad notepad) {
        return notepadRepository.save(notepad);
    }

    @RequestMapping(value = "/notepad/{notepadId}", method = RequestMethod.GET)
    public Notepad getNotePad(@PathVariable("notepadId") String notepadId) {
        Notepad notepad = notepadRepository.findOne(notepadId);
        if (notepad != null) {
            List<Note> notes = noteRepository.findByNotepadId(notepadId);
            notepad.setNotes(notes);
        }
        return notepad;
    }

    @RequestMapping(value = "/notepad/{notepadId}/note", method = RequestMethod.POST)
    public Note createNote(@PathVariable("notepadId") String notepadId, @RequestBody @Valid final Note note) {
        note.setNotepadId(notepadId);
        return noteRepository.save(note);
    }
}
