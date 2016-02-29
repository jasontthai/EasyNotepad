/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author trit
 *
 */
@RestController
public class NotepadController {

    @RequestMapping(value = "/notepad")
    public String getNote() {
        return "notepad";
    }
}
