package com.example.fixture_monkey_demo;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.ConstructorPropertiesArbitraryGenerator;
import com.navercorp.fixturemonkey.generator.FieldReflectionArbitraryGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class PersonTest {

    @DisplayName("fixture monkey 테스트")
    @RepeatedTest(100)
    void name() {
        //given
        FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
                .defaultGenerator(ConstructorPropertiesArbitraryGenerator.INSTANCE)
                .build();

        //when
        String idValue = "123";

        Team team = fixtureMonkey.giveMeBuilder(new Team())
                .setNotNull("id")
                .setNotNull("name")
                .sample();

        Person person = fixtureMonkey.giveMeBuilder(new Person())
                .set("id", idValue)
                .setNotNull("name")
                .sample();

        //then
        Assertions.assertThat(person.getId()).isEqualTo(idValue);
        Assertions.assertThat(person.getName()).isNotNull();
        System.out.println(person.toString());
    }

    @DisplayName("fixture monkey dto 테스트")
    @RepeatedTest(100)
    void name2() {
        //given
        FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
                .putGenerator(PersonDto.class, FieldReflectionArbitraryGenerator.INSTANCE)
                .putGenerator(TeamDto.class, FieldReflectionArbitraryGenerator.INSTANCE)
                .build();
        //when
        String idValue = "123";

        TeamDto teamDto = fixtureMonkey.giveMeBuilder(new TeamDto())
                .setNotNull("id")
                .setNotNull("name")
                .sample();

        PersonDto personDto = fixtureMonkey.giveMeBuilder(new PersonDto())
                .set("id", idValue)
                .setNotNull("name")
                .sample();

        teamDto.addPeople(personDto);

        //then
        Assertions.assertThat(personDto.getId()).isEqualTo(idValue);
        Assertions.assertThat(personDto.getName()).isNotNull();
        System.out.println(personDto.getName());
        System.out.println(personDto.getTeam());
    }
}