package hello.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hello.beans.Hello;
import hello.repositories.HelloRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private HelloRepository helloRepository;

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        logger.info("hello world");
        return "index";
    }

    @RequestMapping(value = "/hellos", method = RequestMethod.POST)
    @ResponseBody
    public Hello createHello(@RequestBody @Valid final Hello hello) {
        return helloRepository.save(hello);
    }

    @RequestMapping(value = "/hellos")
    @ResponseBody
    public List<Hello> getHellos() {
        return helloRepository.findAll();
    }

    @RequestMapping("/wakemydyno.txt")
    public @ResponseBody String getText() {
        return "Hello world";
    }
}