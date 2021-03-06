package pl.patrykbartnicki.PersonReadData.fileControllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.patrykbartnicki.PersonReadData.repositories.PersonRepository;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class DatabaseFiller implements ApplicationListener<ContextRefreshedEvent> {

    private CSV_reader csv_reader = new CSV_reader();
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        log.info("Data Loading...");
        addPeopleFromFile();
        log.debug("Data loaded");

    }

    private void addPeopleFromFile(){

        personRepository.deleteAll().
                thenMany(Flux.just(csv_reader.getPeopleList())).
                flatMap(personRepository::saveAll).
                subscribe(System.out::println);
    }
}