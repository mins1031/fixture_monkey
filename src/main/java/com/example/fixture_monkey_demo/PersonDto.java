package com.example.fixture_monkey_demo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.beans.ConstructorProperties;
import java.util.Objects;

@Getter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class PersonDto {

    private String id;
    private String name;
    private TeamDto team;

    @ConstructorProperties({"id", "name", "team"})
    public PersonDto(String id, String name, TeamDto team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }
}
