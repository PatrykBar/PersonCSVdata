package pl.patrykbartnicki.PersonReadData.repositories;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pl.patrykbartnicki.PersonReadData.models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {

    @Query("SELECT * FROM person ORDER BY date_of_birth ASC")
    Flux<Person> findAllSortedByAge();

    @Query("SELECT MIN(date_of_birth) FROM person WHERE name IS NOT NULL")
    Mono<Person> findTheOldestPerson();

}
