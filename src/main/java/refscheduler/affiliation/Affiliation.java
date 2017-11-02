package refscheduler.affiliation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import refscheduler.person.Person;
import refscheduler.team.Team;

import javax.validation.constraints.NotNull;

/**
 * Team Affiliation Get DTO.
 */
public class Affiliation implements Comparable<Affiliation> {

    private Long id;

    @NotNull
    private Long tournamentId;

    @NotNull
    private Person person;

    @NotNull
    private Team team;

    private AffiliationType affiliation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public AffiliationType getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(AffiliationType affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }

    @Override
    public int compareTo(final Affiliation that) {
        if (this.equals(that)) {
            return 0;
        }

        final int affiliationComparison = this.affiliation.compareTo(that.affiliation);

        if (affiliationComparison == 0) {
            return this.person.compareTo(that.person);
        } else {
            return affiliationComparison;
        }
    }
}
