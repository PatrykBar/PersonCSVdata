package pl.patrykbartnicki.PersonReadData.service;

import pl.patrykbartnicki.PersonReadData.models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    public Mono<Long> howManyUsers();

    public Flux<Person> peopleSortedByAge();

    public Mono<Person> theOldestPerson();
}
