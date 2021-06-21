package pl.patrykbartnicki.PersonReadData.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Getter
@Setter
@Table("Person")
public class Person {

    @Id
    private Long id;

    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    private int phoneNumber;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
