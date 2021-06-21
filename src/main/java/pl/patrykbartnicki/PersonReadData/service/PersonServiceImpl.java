package pl.patrykbartnicki.PersonReadData.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patrykbartnicki.PersonReadData.models.Person;
import pl.patrykbartnicki.PersonReadData.repositories.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Mono<Long> howManyUsers() {
        return personRepository.count();
    }

    @Override
    public Flux<Person> peopleSortedByAge() {
        return personRepository.findAllSortedByAge();
    }

    @Override
    public Mono<Person> theOldestPerson() {
        return personRepository.findTheOldestPerson();
    }
}
