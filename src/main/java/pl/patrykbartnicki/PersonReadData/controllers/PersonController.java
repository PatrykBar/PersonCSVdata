package pl.patrykbartnicki.PersonReadData.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.patrykbartnicki.PersonReadData.models.Person;
import pl.patrykbartnicki.PersonReadData.service.PersonServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonServiceImpl personService;

    @GetMapping({"/sortedByAge"})
    public Flux<Person> getPersonSortedByAge(){
        return personService.peopleSortedByAge();
    }

    @GetMapping({"/theOldestPerson"})
    public Mono<Person> getTheOldestPerson(){
        return personService.theOldestPerson();
    }

    @GetMapping({"/count"})
        public Mono<Long> getCountOfPeople(){
        return personService.howManyUsers();
    }

}
