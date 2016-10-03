package refscheduler.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Team Affiliation Get DTO.
 */
public class TeamAffiliationGet implements Comparable<TeamAffiliationGet> {

    private Long affiliationId;

    private PersonGet person;

    private TeamGet team;

    private AffiliationType affiliation;

    public Long getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(Long affiliationId) {
        this.affiliationId = affiliationId;
    }

    public PersonGet getPerson() {
        return person;
    }

    public void setPerson(PersonGet person) {
        this.person = person;
    }

    public TeamGet getTeam() {
        return team;
    }

    public void setTeam(TeamGet team) {
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
    public int compareTo(final TeamAffiliationGet that) {
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
