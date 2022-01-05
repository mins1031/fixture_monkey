package com.example.fixture_monkey_demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.beans.ConstructorProperties;

@Getter
@NoArgsConstructor
@Entity
@ToString(exclude = "team")
public class Person {

    @Id @GeneratedValue
    private String id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public Person(String name) {
        this.name = name;
    }

    @ConstructorProperties({"id", "name", "team"})
    public Person(String id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
