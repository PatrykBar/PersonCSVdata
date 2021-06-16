package pl.patrykbartnicki.PersonReadData.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.patrykbartnicki.PersonReadData.fileControllers.CSV_reader;
import pl.patrykbartnicki.PersonReadData.models.Person;
import pl.patrykbartnicki.PersonReadData.repositories.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;

    @Override
    public Mono<Long> howManyUsers() {
        return personRepository.count();
    }

    @Override
    public Flux<Person> peopleSortedByAge() {
        List<Person> sortedPeople = new ArrayList<>();
        sortedPeople.addAll((Collection<? extends Person>) personRepository.findAll());

        return null;
    }

    @Override
    public Mono<Person> theOldestPerson() {

        return null;
    }
}
