package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private HelloRepository helloRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value="/hellos", method = RequestMethod.POST)
    @ResponseBody
    public Hello createHello(@RequestBody @Valid final Hello hello) {
        return helloRepository.save(hello);
    }

    @RequestMapping(value="/hellos")
    @ResponseBody
    public List<Hello> getHellos() {
        return helloRepository.findAll();
    }
}