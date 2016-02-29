/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.beans.Notepad;
import hello.repositories.NotepadRepository;

/**
 * @author trit
 *
 */
@RestController
public class NotepadController {

    @Autowired
    private NotepadRepository notepadRepository;

    @RequestMapping(value = "/notepad")
    @ResponseBody
    public List<Notepad> getNotePads() {
        return notepadRepository.findAll();
    }

    @RequestMapping(value = "/notepad", method = RequestMethod.POST)
    @ResponseBody
    public Notepad createNotepad(@RequestBody @Valid final Notepad notepad) {
        return notepadRepository.save(notepad);
    }
}
