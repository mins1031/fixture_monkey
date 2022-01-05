package com.example.fixture_monkey_demo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class TeamDto {

    private String id;
    private String name;
    private List<PersonDto> people = new ArrayList<>();
//    private List<String> people = new ArrayList<>();

    @ConstructorProperties({"id", "name", "people"})
    public TeamDto(String id, String name, List<PersonDto> people/*List<String> people*/) {
        this.id = id;
        this.name = name;
        this.people = people;
    }

    public void addPeople(PersonDto personDto) {
        this.people.add(personDto);
        personDto.setTeam(this);
    }
}
