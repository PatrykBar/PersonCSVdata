package pl.patrykbartnicki.PersonReadData.repositories;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import pl.patrykbartnicki.PersonReadData.models.Person;

@Repository
public interface PersonRepository extends ReactiveSortingRepository<Person, Long> {
}
