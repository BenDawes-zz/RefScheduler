package refscheduler.affiliation.builder;

import refscheduler.affiliation.Affiliation;
import refscheduler.affiliation.AffiliationType;
import refscheduler.person.Person;
import refscheduler.team.Team;

public class AffiliationBuilder {

    private Long id;
    private Person person;
    private Team team;
    private AffiliationType affiliationType;

    private AffiliationBuilder() {

    }

    public static AffiliationBuilder newAffiliation() {
        return new AffiliationBuilder();
    }

    public AffiliationBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public AffiliationBuilder withPerson(Person person) {
        this.person = person;
        return this;
    }

    public AffiliationBuilder withTeam(Team team) {
        this.team = team;
        return this;
    }

    public AffiliationBuilder withAffiliationType(AffiliationType affiliationType) {
        this.affiliationType = affiliationType;
        return this;
    }

    public Affiliation build() {
        Affiliation affiliation = new Affiliation();
        affiliation.setId(id);
        affiliation.setPerson(person);
        affiliation.setTeam(team);
        affiliation.setAffiliation(affiliationType);
        return affiliation;
    }
}
