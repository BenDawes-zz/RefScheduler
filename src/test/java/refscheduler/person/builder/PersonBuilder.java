package refscheduler.person.builder;

import refscheduler.person.Level;
import refscheduler.person.Person;

public class PersonBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Level headRefereeLevel;
    private Level assistantRefereeLevel;
    private Level snitchRefereeLevel;
    private Boolean snitch;

    private PersonBuilder() {

    }

    public static PersonBuilder newPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withId(final Long id) {
        this.id = id;
        return this;
    }

    public PersonBuilder withFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public PersonBuilder withHeadRefereeLevel(final Level headRefereeLevel) {
        this.headRefereeLevel = headRefereeLevel;
        return this;
    }

    public PersonBuilder withAssistantRefereeLevel(final Level assistantRefereeLevel) {
        this.assistantRefereeLevel = assistantRefereeLevel;
        return this;
    }

    public PersonBuilder withSnitchRefereeLevel(final Level snitchRefereeLevel) {
        this.snitchRefereeLevel = snitchRefereeLevel;
        return this;
    }

    public PersonBuilder withSnitch(final Boolean snitch) {
        this.snitch = snitch;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmailAddress(emailAddress);
        person.setHeadRefereeLevel(headRefereeLevel);
        person.setAssistantRefereeLevel(assistantRefereeLevel);
        person.setSnitchRefereeLevel(snitchRefereeLevel);
        person.setSnitch(snitch);
        return person;
    }
}
