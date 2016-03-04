/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.beans.Note;
import hello.beans.Notepad;
import hello.repositories.NoteRepository;
import hello.repositories.NotepadRepository;

/**
 * @author trit
 *
 */
@Controller
public class NotepadController {

    private static final Logger logger = LoggerFactory.getLogger(NotepadController.class);

    @Autowired
    private NotepadRepository notepadRepository;

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(value = "/notepads")
    public String getNotePads(Model model) {
        model.addAttribute("notepad", new Notepad());
        model.addAttribute("notepads", notepadRepository.findAll());
        return "notepad";
    }

    @RequestMapping(value = "/notepads", method = RequestMethod.POST)
    public String createNotepad(@ModelAttribute @RequestBody @Valid final Notepad notepad, Model model) {
        logger.info("Saving notepad: {}", notepad);
        notepadRepository.save(notepad);
        model.addAttribute("notepad", new Notepad());
        model.addAttribute("notepads", notepadRepository.findAll());
        model.addAttribute("created", true);
        return "notepad";
    }

    @RequestMapping(value = "/notepads/{notepadId}", method = RequestMethod.GET)
    @ResponseBody
    public Notepad getNotePad(@PathVariable("notepadId") String notepadId) {
        Notepad notepad = notepadRepository.findOne(notepadId);
        if (notepad != null) {
            List<Note> notes = noteRepository.findByNotepadId(notepadId);
            notepad.setNotes(notes);
        }
        logger.info("Returning notepad: {}", notepad);
        return notepad;
    }

    @RequestMapping(value = "/notepads/{notepadId}", method = RequestMethod.DELETE)
    public String deleteNotepad(@PathVariable("notepadId") String notepadId, Model model) {
        logger.info("Removing notepad with id: {}", notepadId);
        notepadRepository.delete(notepadId);
        model.addAttribute("notepad", new Notepad());
        model.addAttribute("notepads", notepadRepository.findAll());
        return "notepad";
    }

    @RequestMapping(value = "/notepads/{notepadId}/notes")
    public String getNotes(@PathVariable("notepadId") String notepadId, Model model) {
        logger.info("Getting notes from notepad: {}", notepadId);
        List<Note> notes = noteRepository.findByNotepadId(notepadId);
        model.addAttribute("notes", notes);
        return "note";
    }

    @RequestMapping(value = "/notepads/{notepadId}/notes", method = RequestMethod.POST)
    public Note createNote(@PathVariable("notepadId") String notepadId, @RequestBody @Valid final Note note) {
        note.setNotepadId(notepadId);
        logger.info("Creating note: {}", note);
        return noteRepository.save(note);
    }
}
