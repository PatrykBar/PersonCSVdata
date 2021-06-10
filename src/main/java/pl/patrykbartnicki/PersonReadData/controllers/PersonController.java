package pl.patrykbartnicki.PersonReadData.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.patrykbartnicki.PersonReadData.service.PersonServiceImpl;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

}
