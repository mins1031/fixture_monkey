package com.example.fixture_monkey_demo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "people")
public class Team {

    @Id
    private String id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Person> people = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    @ConstructorProperties({"id", "name", "people"})
    public Team(String id, String name, List<Person> people) {
        this.id = id;
        this.name = name;
        this.people = people;
    }

    public void addAllPeople(List<Person> people) {
        this.people.addAll(people);
        for (Person person : people) {
            person.setTeam(this);
        }
    }
}
